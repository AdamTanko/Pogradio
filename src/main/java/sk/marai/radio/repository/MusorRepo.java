package sk.marai.radio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.marai.radio.model.Musor;

@Repository
public interface MusorRepo extends CrudRepository<Musor, Long> {
}
