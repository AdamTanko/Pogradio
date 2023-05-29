package sk.marai.radio.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.marai.radio.model.Showtime;
import sk.marai.radio.repository.MusorIdoRepo;

import java.time.LocalTime;

@Controller
@RequestMapping("/musorido")
public class MusorIdoController {

    @Autowired
    private MusorIdoRepo musorIdoRepo;

    //create
    @PostMapping("/new")
    public @ResponseBody
    Showtime add(@RequestParam String nap, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.TIME) LocalTime startido, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.TIME) LocalTime endido, @RequestParam Long musorid) {
        Showtime m = new Showtime(nap, startido, endido, musorid);
        musorIdoRepo.save(m);
        return m;
    }

    //get by id
    @GetMapping("/findbyid/{id}")
    public @ResponseBody Showtime getById(@PathVariable Long id) {
        return musorIdoRepo.findById(id).orElse(null);
    }

    // get all
    @GetMapping("/all")
    public @ResponseBody Iterable<Showtime> getAllMusorIdo() {
        return musorIdoRepo.findAll();

    }

    // update
    @PutMapping("/update")
    public @ResponseBody Showtime update(@RequestBody Showtime m) {
        Showtime a = musorIdoRepo.findById(m.getId()).orElse(null);
        a.setDay(m.getDay());
        a.setStartTime(m.getStartTime());
        a.setEndTime(m.getEndTime());
        a.setId(m.getId());
        musorIdoRepo.save(a);
        return m;
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public @ResponseBody Showtime delete(@PathVariable Long id) {
        Showtime b = musorIdoRepo.findById(id).orElse(null);
        musorIdoRepo.deleteById(id);
        return b;
    }
}