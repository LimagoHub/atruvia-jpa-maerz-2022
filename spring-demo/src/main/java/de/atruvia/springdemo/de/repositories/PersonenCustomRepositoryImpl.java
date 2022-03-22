package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;


@Repository
public class PersonenCustomRepositoryImpl implements PersonenCustomRepository{

    @Autowired
    private EntityManager em;

    @Override
    public void speichern(PersonEntity person) {
        em.persist(person);
    }
}
