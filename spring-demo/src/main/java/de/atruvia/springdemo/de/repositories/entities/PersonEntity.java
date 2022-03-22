package de.atruvia.springdemo.de.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name ="tbl_personen")
public class PersonEntity {

    @Id
    private String id;
    private String vorname;
    private String nachname;

}
