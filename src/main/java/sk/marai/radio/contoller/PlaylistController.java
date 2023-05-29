package sk.marai.radio.contoller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
@RequestMapping("/playlist")

public class PlaylistController {

    private static class Music {
        public String title;
        public String artist;
        public String album;
        public int year;
        public Long duration;
        public String[] tags;
    }

    public static ArrayList<Music> musicArrayList = new ArrayList<>();


    public void parseInput() {
        try {
            System.out.println("Reading");
            File f = new File("docs/zenek.csv"); // filepath to file containing the list of music available
            Scanner sc2 = new Scanner(f);
            sc2.nextLine();
            while (sc2.hasNextLine()) {
                String scnextlinestring = sc2.nextLine();
                Scanner sc = new Scanner(scnextlinestring).useDelimiter(",");
                Music z = new Music();
                z.title = sc.next();
                z.artist = sc.next();
                z.album = sc.next();
                z.year = Integer.parseInt(sc.next());
                z.duration = Long.parseLong(sc.next());
                z.tags = sc.next().split(";");
                musicArrayList.add(z);
                sc.close();
            }
            System.out.println("Reading complete");
            sc2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/generate/{tagtogenerateby}/{howmanysongs}")
    public @ResponseBody String generateplaylist(@PathVariable String tagtogenerateby, @PathVariable long howmanysongs) {

        if (musicArrayList.size() == 0) {
            parseInput();
        }
        ArrayList<Music> playlistarray = new ArrayList<>();
        // search based on tag (got from the path)
        for (Music z : musicArrayList) {
            for (int i = 0; i < z.tags.length; i++) {
                if (z.tags[i].equals(tagtogenerateby)) {
                    playlistarray.add(z);
                    break;
                }
            }
        }
        //generate filename (just the current date and time)
        String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm"));
        //file creation
        long x = Math.min(howmanysongs, playlistarray.size());

        String filenev = tagtogenerateby + "-" + x + "-" + formattedDate;
        File f = new File("Playlists/" + filenev + ".txt");
        //writing to the file
        int d = 0;
        try {
            FileWriter fw = new FileWriter(f);
            for (Music z :
                    playlistarray) {
                StringBuilder music = new StringBuilder(z.title + "," + z.artist + "," + z.album + "," + z.year + "," + z.duration + ",");
                for (int i = 0; i < z.tags.length; i++) {
                    music.append(z.tags[i]).append(";");
                }
                music.append("\n");
                fw.write(music.toString());
                d++;
                if (d == x) {
                    break;
                }
            }
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return "Succesfully generated the '" + filenev + "' playlist.";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Music> getAllMusic() {
        if (musicArrayList.size() == 0) {
            parseInput();
        }
        return musicArrayList;
    }

    @GetMapping("/findby/{columnnumber}/{searchquery}")
    public @ResponseBody Iterable<Music> getby(@PathVariable int columnnumber, @PathVariable String searchquery) {
        if (musicArrayList.size() == 0) {
            parseInput();
        }
        ArrayList<Music> finalarray = new ArrayList<>();
        switch (columnnumber) {
            case 1:
                for (Music z : musicArrayList) {
                    if (z.title.contains(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 2:
                for (Music z : musicArrayList) {
                    if (z.artist.equals(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 3:
                for (Music z : musicArrayList) {
                    if (z.album.equals(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 4:
                for (Music z : musicArrayList) {
                    if (z.year == Integer.parseInt(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 5:
                for (Music z : musicArrayList) {
                    if (z.duration == Long.parseLong(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 6:
                for (Music z : musicArrayList) {
                    for (int i = 0; i < z.tags.length; i++) {
                        if (z.tags[i].equals(searchquery)) {
                            finalarray.add(z);
                            break;
                        }
                    }
                }
                break;
        }

        return finalarray;
    }
}
