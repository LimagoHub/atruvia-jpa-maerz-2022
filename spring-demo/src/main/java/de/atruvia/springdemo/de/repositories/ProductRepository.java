package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {

    @Query("Select p.productName from Product p where p.unitPrice > (select avg(unitPrice) from Product)")
    List<String> expensiveProducts();
}
