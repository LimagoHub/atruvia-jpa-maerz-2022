package de.atruvia.springdemo;

import de.atruvia.springdemo.de.repositories.*;
import de.atruvia.springdemo.de.repositories.entities.ChefKnecht;
import de.atruvia.springdemo.de.repositories.entities.PersonEntity;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
public class DemoRunner implements CommandLineRunner {

    private final KlassikRepository repo;

    @Override
    public void run(String... args) throws ServiceException {


        repo.ausgabe();


    }
}
