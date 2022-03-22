package de.limago.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_barkeepers")
public class Barkeeper {
    @Id
    private String id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(nullable = false) // referenzielle Integrität
    //@JoinTable(name = "tbl_bar_barkeeper")// N-Seite
    private Bar bar;


    private String keepername;
}
