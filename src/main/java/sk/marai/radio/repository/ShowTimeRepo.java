package sk.marai.radio.repository;

import org.springframework.data.repository.CrudRepository;
import sk.marai.radio.model.Showtime;

public interface ShowTimeRepo extends CrudRepository<Showtime, Long> {
}
