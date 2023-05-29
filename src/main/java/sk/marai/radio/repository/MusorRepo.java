package sk.marai.radio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.marai.radio.model.Show;

@Repository
public interface MusorRepo extends CrudRepository<Show, Long> {
}
