package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonenRepository extends CrudRepository<PersonEntity,String>, PersonenCustomRepository {


    @Query("update PersonEntity p set p.vorname = :vorname where p.id = :id")
    void updateVorname(String id, String vorname);
}
