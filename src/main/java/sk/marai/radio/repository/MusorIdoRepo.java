package sk.marai.radio.repository;

import org.springframework.data.repository.CrudRepository;
import sk.marai.radio.model.Showtime;

public interface MusorIdoRepo  extends CrudRepository<Showtime, Long> {
}
