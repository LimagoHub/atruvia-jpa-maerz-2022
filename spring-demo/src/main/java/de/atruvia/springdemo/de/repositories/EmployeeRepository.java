package de.atruvia.springdemo.de.repositories;

import de.atruvia.springdemo.de.repositories.entities.ChefKnecht;
import de.atruvia.springdemo.de.repositories.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("select new de.atruvia.springdemo.de.repositories.entities.ChefKnecht(chef.lastName,knecht.lastName) from Employee knecht left outer join knecht.reportsTo chef")
    List<ChefKnecht> findKnechte();


//    @Query("select  de.atruvia.springdemo.de.repositories.entities.ChefKnecht.builder().chef(chef.lastName).knecht(knecht.lastName).build() from Employee knecht left outer join knecht.reportsTo chef")
//    List<ChefKnecht> findKnechte();


    @Query("select new de.atruvia.springdemo.de.repositories.entities.ChefKnecht(chef.lastName,knecht.lastName) from Employee knecht left outer join Employee chef on knecht.reportsTo = chef.id")
    List<ChefKnecht> findKnechteII();
}
