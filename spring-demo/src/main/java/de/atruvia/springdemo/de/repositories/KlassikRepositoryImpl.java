package de.atruvia.springdemo.de.repositories;


import de.atruvia.springdemo.de.repositories.entities.Customer;
import de.atruvia.springdemo.de.repositories.entities.OrderDetail;
import de.atruvia.springdemo.de.repositories.entities.OrderDetailId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

@Repository
public class KlassikRepositoryImpl implements KlassikRepository{

    @Autowired
    private EntityManager em;
    @Override
    public void ausgabe() {

        EntityGraph graph = this.em.getEntityGraph("graph.Customer.orders");

        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", graph);

        OrderDetailId id = new OrderDetailId(10248,11);
        OrderDetail od = em.find(OrderDetail.class, id);
        System.out.println(od);
        System.out.println(od.getProductID());
    }
    }
