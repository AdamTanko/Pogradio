package sk.marai.radio.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.*;

@Entity
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long showid;

    public Showtime() {

    }
    public Showtime(String day, LocalTime startTime, LocalTime endTime, Long showid) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showid = showid;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Long getShowid() {
        return showid;
    }
    public void setShowid(Long showid) {
        this.showid = showid;
    }
}
