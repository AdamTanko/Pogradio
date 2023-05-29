package sk.marai.radio.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long showrunnerid;

    public Show() {

    }

    public Show(String title, String leiras, Long musorvezetoid) {
        this.title = title;
        this.description = leiras;
        this.showrunnerid = musorvezetoid;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Long getShowrunnerid() {
        return showrunnerid;
    }
    public void setShowrunnerid(Long showrunnerid) {
        this.showrunnerid = showrunnerid;
    }
}
