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
import java.util.*;

@Controller
@RequestMapping("/playlist")

public class PlaylistController
{

    private static class Zene
    {
        public String title;
        public String artist;
        public String album;
        public int year;
        public Long duration;
        public String[] tags;
    }

    public static ArrayList<Zene> zenek = new ArrayList<>();


    public void beolv()
    {
        try {
            System.out.println("Beolvasás");
            File f = new File("docs/zenek.csv");
            Scanner sc2 = new Scanner(f);
            sc2.nextLine();
            while (sc2.hasNextLine()) {
                String scnextlinestring = sc2.nextLine();
                Scanner sc = new Scanner(scnextlinestring).useDelimiter(",");
                Zene z = new Zene();
                z.title = sc.next();
                z.artist = sc.next();
                z.album = sc.next();
                z.year = Integer.parseInt(sc.next());
                z.duration = Long.parseLong(sc.next());
                z.tags = sc.next().split(";");
                 zenek.add(z);
                sc.close();
            }
            System.out.println("Beolvasva");
            sc2.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/generate/{tagtogenerateby}/{howmanysongs}")
    public @ResponseBody String generateplaylist(@PathVariable String tagtogenerateby,@PathVariable long howmanysongs) {

        if (zenek.size() == 0) {
            beolv();
        }
        ArrayList<Zene> playlistarray = new ArrayList<>();
        //tagek szerinti kereses
        for (Zene z : zenek) {
            for (int i = 0; i < z.tags.length; i++) {
                if (z.tags[i].equals(tagtogenerateby)) {
                    playlistarray.add(z);
                    break;
                }
            }
        }
        //filenev megadasa
        long x = Math.min(howmanysongs, playlistarray.size());
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm");
        String formattedDate = myDateObj.format(myFormatObj);
        //file keszites
        String filenev = tagtogenerateby + "-" + x + "-" + formattedDate;
        File f = new File("Playlists/" +filenev + ".txt");
        //iras a fileba
        int d = 0;
        try {
            FileWriter myWriter = new FileWriter(f);
            for (Zene z:
                 playlistarray) {
                StringBuilder zene = new StringBuilder(z.title + "," + z.artist + "," + z.album + "," + z.year + "," + z.duration + ",");
                for (int i = 0; i < z.tags.length; i++) {
                    zene.append(z.tags[i]).append(";");
                }
                zene.append("\n");
                myWriter.write(zene.toString());
                d++;
                if (d == x) {
                    break;
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Hiba tortent.");
            e.printStackTrace();
        }
        return "Sikeresen lett generalva a '" + filenev + "' lejatszasilista.";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Zene> getAllZene() {
        if (zenek.size() == 0) {
            beolv();
        }
        return zenek;
    }

    @GetMapping("/findby/{coulmnnumber}/{searchquery}")
    public @ResponseBody Iterable<Zene> getby(@PathVariable int coulmnnumber, @PathVariable String searchquery) {
        if (zenek.size() == 0) {
            beolv();
        }
        ArrayList<Zene> finalarray = new ArrayList<>();
        switch (coulmnnumber){
            case 1:
                for (Zene z : zenek) {
                    if (z.title.contains(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 2:
                for (Zene z : zenek) {
                    if (z.artist.equals(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 3:
                for (Zene z : zenek) {
                    if (z.album.equals(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 4:
                for (Zene z : zenek) {
                    if (z.year == Integer.parseInt(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 5:
                for (Zene z : zenek) {
                    if (z.duration == Long.parseLong(searchquery)) {
                        finalarray.add(z);
                    }
                }
                break;
            case 6:
                for (Zene z : zenek) {
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
