package sk.marai.radio.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.*;

@Entity
public class MusorIdo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nap;
    private LocalTime startido;
    private LocalTime endido;
    private Long musorid;

    public MusorIdo() {

    }
    public MusorIdo(String nap, LocalTime startido, LocalTime endido, Long musorid) {
        this.nap = nap;
        this.startido = startido;
        this.endido = endido;
        this.musorid = musorid;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNap() {
        return nap;
    }
    public void setNap(String nap) {
        this.nap = nap;
    }

    public LocalTime getStartido() {
        return startido;
    }
    public void setStartido(LocalTime startido) {
        this.startido = startido;
    }

    public LocalTime getEndido() {
        return endido;
    }
    public void setEndido(LocalTime endido) {
        this.endido = endido;
    }

    public Long getMusorid() {
        return musorid;
    }
    public void setMusorid(Long musorid) {
        this.musorid = musorid;
    }
}
