package sk.marai.radio.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.marai.radio.model.Show;
import sk.marai.radio.repository.MusorRepo;

@Controller
@RequestMapping("/musor")
public class MusorController {

    @Autowired
    private MusorRepo musorRepo;

    //create
    @PostMapping("/new")
    public @ResponseBody
    Show add(@RequestParam String cim, @RequestParam String leiras, @RequestParam Long musorvezetoid) {
        Show m = new Show(cim, leiras, musorvezetoid);
        musorRepo.save(m);
        return m;
    }

    //get by id
    @GetMapping("/findbyid/{id}")
    public @ResponseBody Show getById(@PathVariable Long id) {
        return musorRepo.findById(id).orElse(null);

    }

    // get all
    @GetMapping("/all")
    public @ResponseBody Iterable<Show> getAllMusor() {
        return musorRepo.findAll();

    }

    // update
    @PutMapping("/update")
    public @ResponseBody Show update(@RequestBody Show m) {
        Show a = musorRepo.findById(m.getId()).orElse(null);
        a.setTitle(m.getTitle());
        a.setDescription(m.getDescription());
        a.setId(m.getId());
        musorRepo.save(a);
        return m;
    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    public @ResponseBody Show delete(@PathVariable Long id) {
        Show b = musorRepo.findById(id).orElse(null);
        musorRepo.deleteById(id);
        return b;
    }
}