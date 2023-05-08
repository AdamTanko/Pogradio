package sk.marai.radio.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.marai.radio.model.Musorvezeto;
import sk.marai.radio.repository.MusorvezetoRepo;

@Controller
@RequestMapping("/musorvezeto")
public class MusorvezetoController {

    @Autowired
    private MusorvezetoRepo musorvezetoRepo;

    //create
    @PostMapping("/new")
    public @ResponseBody Musorvezeto add(@RequestParam String nev, @RequestParam String leiras, @RequestParam String kep) {
        Musorvezeto m = new Musorvezeto(nev, leiras, kep);
        musorvezetoRepo.save(m);
        return m;
    }

    // get by id
    @GetMapping("/findbyid/{id}")
    public @ResponseBody Musorvezeto getById(@PathVariable Long id) {
        return musorvezetoRepo.findById(id).orElse(null);
    }

    // get all
    @GetMapping("/all")
    public @ResponseBody Iterable<Musorvezeto> getAllMusorvezeto() {
        return musorvezetoRepo.findAll();
    }

    //UPDATE 2.0
    @PutMapping("/update")
    public @ResponseBody Musorvezeto update(@RequestBody Musorvezeto m) {
        Musorvezeto a = musorvezetoRepo.findById(m.getId()).orElse(null);
        a.setNev(m.getNev());
        a.setLeiras(m.getLeiras());
        a.setKep(m.getKep());
        musorvezetoRepo.save(a);
        return m;
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public @ResponseBody Musorvezeto delete(@PathVariable Long id) {
        Musorvezeto b = musorvezetoRepo.findById(id).orElse(null);
        musorvezetoRepo.deleteById(id);
        return b;

    }

}