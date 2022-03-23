package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Integer> {


}
