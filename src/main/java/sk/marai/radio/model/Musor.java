package sk.marai.radio.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Musor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cim;
    private String leiras;
    private Long musorvezetoid;

    public Musor() {

    }

    public Musor(String cim, String leiras, Long musorvezetoid) {
        this.cim = cim;
        this.leiras = leiras;
        this.musorvezetoid = musorvezetoid;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }
    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getLeiras() {
        return leiras;
    }
    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public Long getMusorvezetoid() {
        return musorvezetoid;
    }
    public void setMusorvezetoid(Long musorvezetoid) {
        this.musorvezetoid = musorvezetoid;
    }
}
