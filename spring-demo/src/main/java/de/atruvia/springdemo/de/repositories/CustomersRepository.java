package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.Customer;
import de.atruvia.springdemo.de.repositories.entities.TinyCustomer;
import de.atruvia.springdemo.de.repositories.entities.TinyCustomerUmsatz;
import de.atruvia.springdemo.de.repositories.entities.TinyCustomerUmsatzRelativ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer,String> {

    List<Customer> findByCity(String city);

//    @Query("select new de.repositories.entities.TinyCustomer(c.companyName, c.city) from Customer c")
//    List<TinyCustomer> findAllTinyCustomers();

    @Query("select distinct c from Customer c left join fetch c.orders o where c.city = :city")
    List<Customer> findDistinctCustomersWithOrders(String city);

    List<Customer> findNachKontakt(String contactName);


    @Query("select c.companyName, count(o.id)  from Customer c left join c.orders o group by c.companyName order by count(o.id) asc")
    List<Object[]> anzahlBestellungenJeKunde();

    @Query("select new de.atruvia.springdemo.de.repositories.entities.TinyCustomerUmsatz(c.companyName, sum(od.quantity * od.unitPrice))  from Customer c left join c.orders o left join o.orderDetails od group by c.companyName order by sum(od.quantity * od.unitPrice) asc")
    List<TinyCustomerUmsatz> umsaetzeJeKunde();

/*
select c.country, sum (od.UnitPrice * od.Quantity) / (select sum(Quantity * UnitPrice) from `order details`) from customers c left outer join orders o on c.CustomerID = o.CustomerID left join `order details` od on o.OrderID = od.OrderID group by c.country
 */

    @Query("select new de.atruvia.springdemo.de.repositories.entities.TinyCustomerUmsatzRelativ(c.country,  sum (od.unitPrice * od.quantity) / (select sum(quantity * unitPrice) from OrderDetail))   from Customer c left outer join Order o on c.id = o.customerID left join OrderDetail od on o.id = od.orderID group by c.country")
    List<TinyCustomerUmsatzRelativ> umsaetzeJeLandRelativ();

}
