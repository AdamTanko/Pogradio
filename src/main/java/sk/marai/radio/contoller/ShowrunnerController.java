package sk.marai.radio.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.marai.radio.model.Showrunner;
import sk.marai.radio.repository.ShowrunnerRepo;

@Controller
@RequestMapping("/showrunner")
public class ShowrunnerController {

    @Autowired
    private ShowrunnerRepo showrunnerRepo;

    //create
    @PostMapping("/new")
    public @ResponseBody Showrunner add(@RequestParam String nev, @RequestParam String leiras, @RequestParam String kep) {
        Showrunner m = new Showrunner(nev, leiras, kep);
        showrunnerRepo.save(m);
        return m;
    }

    // get by id
    @GetMapping("/findbyid/{id}")
    public @ResponseBody Showrunner getById(@PathVariable Long id) {
        return showrunnerRepo.findById(id).orElse(null);
    }

    // get all
    @GetMapping("/all")
    public @ResponseBody Iterable<Showrunner> getAllShowrunners() {
        return showrunnerRepo.findAll();
    }

    //UPDATE 2.0
    @PutMapping("/update")
    public @ResponseBody Showrunner update(@RequestBody Showrunner m) {
        Showrunner a = showrunnerRepo.findById(m.getId()).orElse(null);
        a.setName(m.getName());
        a.setDescription(m.getDescription());
        a.setPicture(m.getPicture());
        showrunnerRepo.save(a);
        return m;
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public @ResponseBody Showrunner delete(@PathVariable Long id) {
        Showrunner b = showrunnerRepo.findById(id).orElse(null);
        showrunnerRepo.deleteById(id);
        return b;

    }

}