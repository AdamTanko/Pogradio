package sk.marai.radio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sk.marai.radio.model.Musorvezeto;

@Repository
public interface MusorvezetoRepo extends CrudRepository<Musorvezeto, Long> {

}
