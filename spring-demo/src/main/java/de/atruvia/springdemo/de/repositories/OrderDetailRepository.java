package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.OrderDetail;
import de.atruvia.springdemo.de.repositories.entities.OrderDetailId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailId> {

    @Query("select od from OrderDetail od")
    List<OrderDetail> treffer();
}
