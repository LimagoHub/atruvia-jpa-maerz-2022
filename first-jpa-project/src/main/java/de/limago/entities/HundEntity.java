package de.limago.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

// Lombok
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Entity
@Table(name = "tbl_hunde")
//@DiscriminatorValue("Hund")
public class HundEntity extends AbstractTier {

    private int anzahlBellen;
}
