package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.PersonEntity;

public interface PersonenCustomRepository {

    void speichern(PersonEntity person);
}
