package sk.marai.radio.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.marai.radio.model.Musor;
import sk.marai.radio.model.Musorvezeto;
import sk.marai.radio.repository.MusorRepo;

import javax.persistence.StoredProcedureParameter;

@Controller
@RequestMapping("/musor")
public class MusorController {

    @Autowired
    private MusorRepo musorRepo;

    //create
    @PostMapping("/new")
    public @ResponseBody
    Musor add(@RequestParam String cim, @RequestParam String leiras, @RequestParam Long musorvezetoid) {
        Musor m = new Musor(cim, leiras, musorvezetoid);
        musorRepo.save(m);
        return m;
    }

    //get by id
    @GetMapping("/findbyid/{id}")
    public @ResponseBody Musor getById(@PathVariable Long id) {
        return musorRepo.findById(id).orElse(null);

    }

    // get all
    @GetMapping("/all")
    public @ResponseBody Iterable<Musor> getAllMusor() {
        return musorRepo.findAll();

    }

    // update
    @PutMapping("/update")
    public @ResponseBody Musor update(@RequestBody Musor m) {
        Musor a = musorRepo.findById(m.getId()).orElse(null);
        a.setCim(m.getCim());
        a.setLeiras(m.getLeiras());
        a.setId(m.getId());
        musorRepo.save(a);
        return m;
    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    public @ResponseBody Musor delete(@PathVariable Long id) {
        Musor b = musorRepo.findById(id).orElse(null);
        musorRepo.deleteById(id);
        return b;
    }
}