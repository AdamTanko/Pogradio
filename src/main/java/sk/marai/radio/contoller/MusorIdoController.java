package sk.marai.radio.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.marai.radio.model.MusorIdo;
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
    MusorIdo add(@RequestParam String nap, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.TIME) LocalTime startido, @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.TIME) LocalTime endido, @RequestParam Long musorid) {
        MusorIdo m = new MusorIdo(nap, startido, endido, musorid);
        musorIdoRepo.save(m);
        return m;
    }

    //get by id
    @GetMapping("/findbyid/{id}")
    public @ResponseBody MusorIdo getById(@PathVariable Long id) {
        return musorIdoRepo.findById(id).orElse(null);
    }

    // get all
    @GetMapping("/all")
    public @ResponseBody Iterable<MusorIdo> getAllMusorIdo() {
        return musorIdoRepo.findAll();

    }

    // update
    @PutMapping("/update")
    public @ResponseBody MusorIdo update(@RequestBody MusorIdo m) {
        MusorIdo a = musorIdoRepo.findById(m.getId()).orElse(null);
        a.setNap(m.getNap());
        a.setStartido(m.getStartido());
        a.setEndido(m.getEndido());
        a.setId(m.getId());
        musorIdoRepo.save(a);
        return m;
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public @ResponseBody MusorIdo delete(@PathVariable Long id) {
        MusorIdo b = musorIdoRepo.findById(id).orElse(null);
        musorIdoRepo.deleteById(id);
        return b;
    }
}