package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, String> {

    @Query("select distinct c from Category c inner join fetch c.products p inner join fetch p.supplierID s")
    List<Category> findCategoriesWithProducts();
}
