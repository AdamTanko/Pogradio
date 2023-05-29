package sk.marai.radio.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.marai.radio.model.Showtime;
import sk.marai.radio.repository.ShowTimeRepo;

import java.time.LocalTime;

@Controller
@RequestMapping("/musorido")
public class ShowTimeController {

    @Autowired
    private ShowTimeRepo showTimeRepo;

    //create
    @PostMapping("/new")
    public @ResponseBody
    Showtime add(@RequestParam String day, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.TIME) LocalTime startTime, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.TIME) LocalTime endTime, @RequestParam Long showid) {
        Showtime m = new Showtime(day, startTime, endTime, showid);
        showTimeRepo.save(m);
        return m;
    }

    //get by id
    @GetMapping("/findbyid/{id}")
    public @ResponseBody Showtime getById(@PathVariable Long id) {
        return showTimeRepo.findById(id).orElse(null);
    }

    // get all
    @GetMapping("/all")
    public @ResponseBody Iterable<Showtime> getAllShowTime() {
        return showTimeRepo.findAll();

    }

    // update
    @PutMapping("/update")
    public @ResponseBody Showtime update(@RequestBody Showtime m) {
        Showtime a = showTimeRepo.findById(m.getId()).orElse(null);
        assert a != null;
        a.setDay(m.getDay());
        a.setStartTime(m.getStartTime());
        a.setEndTime(m.getEndTime());
        a.setId(m.getId());
        showTimeRepo.save(a);
        return m;
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public @ResponseBody Showtime delete(@PathVariable Long id) {
        Showtime b = showTimeRepo.findById(id).orElse(null);
        showTimeRepo.deleteById(id);
        return b;
    }
}