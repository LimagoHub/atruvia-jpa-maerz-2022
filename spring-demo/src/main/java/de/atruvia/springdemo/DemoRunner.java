package de.atruvia.springdemo;

import de.atruvia.springdemo.de.repositories.CustomersRepository;
import de.atruvia.springdemo.de.repositories.PersonenRepository;
import de.atruvia.springdemo.de.repositories.entities.PersonEntity;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
public class DemoRunner implements CommandLineRunner {

    private final CustomersRepository repo;

    @Override
    public void run(String... args) throws ServiceException {

        repo.findByCity("London").forEach(System.out::println);
    }
}
