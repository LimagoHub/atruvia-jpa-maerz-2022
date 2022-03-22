package de.limago.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable

public class Kontakt {

    @Builder.Default
    @Column(length = 30)
    private String kontaktArt = "Telefon";

    private String wert;

}
