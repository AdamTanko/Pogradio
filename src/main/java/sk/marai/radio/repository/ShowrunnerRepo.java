package sk.marai.radio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk.marai.radio.model.Showrunner;

@Repository
public interface ShowrunnerRepo extends CrudRepository<Showrunner, Long> {

}
