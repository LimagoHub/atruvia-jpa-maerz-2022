package de.limago.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

// Lombok
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="tbl_personen")
public class PersonEntity {
    @Id
    @Column(length = 36, nullable = false)
    private String id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
    @Column(length = 30)
    private String vorname;
    @Column(length = 30, nullable = false)
    private String nachname;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonEntity that = (PersonEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
