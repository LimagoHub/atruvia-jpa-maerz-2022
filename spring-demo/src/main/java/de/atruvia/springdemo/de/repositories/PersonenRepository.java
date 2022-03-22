package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonenRepository extends CrudRepository<PersonEntity,String>, PersonenCustomRepository {
}
