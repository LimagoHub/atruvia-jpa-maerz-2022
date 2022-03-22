package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.Customer;
import de.atruvia.springdemo.de.repositories.entities.TinyCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer,String> {

    List<Customer> findByCity(String city);

    @Query("select new de.atruvia.springdemo.de.repositories.entities.TinyCustomer(c.companyName, c.city) from Customer c")
    List<TinyCustomer> findAllTinyCustomers();
}
