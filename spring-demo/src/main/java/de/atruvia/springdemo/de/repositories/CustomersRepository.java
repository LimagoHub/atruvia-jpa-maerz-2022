package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer,String> {
}
