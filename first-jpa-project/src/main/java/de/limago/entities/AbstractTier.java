package de.limago.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

// Lombok
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name="tbl_tiere")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "DTYPE", length = 31)
public abstract class AbstractTier {

    @Id
    @Column(length = 36, updatable = false)
    private String id;

    @Version
    private long version;
    @Column(length = 30)
    private String name;
}
