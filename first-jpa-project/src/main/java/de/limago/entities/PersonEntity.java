package de.limago.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

// Lombok
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name="tbl_personen")
public class PersonEntity extends BaseEntity{


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
    @Column(length = 30)
    private String vorname;
    @Column(length = 30, nullable = false)
    private String nachname;

    @Embedded
    @Builder.Default
    private Adresse adresse = new Adresse();

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "tblpersonenKontakte")
    @Builder.Default
    @ToString.Exclude
    private List<Kontakt> kontakte = new ArrayList<>();

//    @ElementCollection(fetch = FetchType.EAGER)
//    private List<String> sprachen = new ArrayList<>();



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonEntity that = (PersonEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

//    @PrePersist
//    public void prePersit() {
//        id = UUID.randomUUID().toString();
//    }
//    @PreUpdate
//    public void updatePersit() {
//        id = UUID.randomUUID().toString();
//    }
}
