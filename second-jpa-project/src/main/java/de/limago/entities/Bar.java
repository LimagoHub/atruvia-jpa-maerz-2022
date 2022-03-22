package de.limago.entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_bars")
public class Bar {

    @Id
    @Column(length = 36)
    private String id;
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "bar", cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Barkeeper> keepers = new ArrayList<>();

    public List<Barkeeper> getKeepers() {
        return Collections.unmodifiableList(keepers);
    }

    public void addBarkeeper(Barkeeper keeper) {
        keeper.setBar(this);
        keepers.add(keeper);
    }

    public void removeBarkeeper(Barkeeper keeper) {
        //keeper.setBar(null);
        keepers.remove(keeper);
    }
}
