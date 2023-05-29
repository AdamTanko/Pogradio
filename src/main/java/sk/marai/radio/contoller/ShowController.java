package sk.marai.radio.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.marai.radio.model.Show;
import sk.marai.radio.repository.ShowRepo;

@Controller
@RequestMapping("/musor")
public class ShowController {

    @Autowired
    private ShowRepo showRepo;

    //create
    @PostMapping("/new")
    public @ResponseBody
    Show add(@RequestParam String title, @RequestParam String description, @RequestParam Long showrunnerid) {
        Show m = new Show(title, description, showrunnerid);
        showRepo.save(m);
        return m;
    }

    //get by id
    @GetMapping("/findbyid/{id}")
    public @ResponseBody Show getById(@PathVariable Long id) {
        return showRepo.findById(id).orElse(null);

    }

    // get all
    @GetMapping("/all")
    public @ResponseBody Iterable<Show> getAllShows() {
        return showRepo.findAll();

    }

    // update
    @PutMapping("/update")
    public @ResponseBody Show update(@RequestBody Show m) {
        Show a = showRepo.findById(m.getId()).orElse(null);
        assert a != null;
        a.setTitle(m.getTitle());
        a.setDescription(m.getDescription());
        a.setId(m.getId());
        showRepo.save(a);
        return m;
    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    public @ResponseBody Show delete(@PathVariable Long id) {
        Show b = showRepo.findById(id).orElse(null);
        showRepo.deleteById(id);
        return b;
    }
}