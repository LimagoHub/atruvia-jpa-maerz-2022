package de.atruvia.springdemo;

import de.atruvia.springdemo.de.repositories.CategoryRepository;
import de.atruvia.springdemo.de.repositories.CustomersRepository;
import de.atruvia.springdemo.de.repositories.OrdersRepository;
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

    private final CategoryRepository repo;

    @Override
    public void run(String... args) throws ServiceException {

        for (var category: repo.findCategoriesWithProducts()) {
            System.out.println(category);
            for (var product: category.getProducts()) {
                System.out.print("\t");
                System.out.println(product);
            }

        }
    }
}
