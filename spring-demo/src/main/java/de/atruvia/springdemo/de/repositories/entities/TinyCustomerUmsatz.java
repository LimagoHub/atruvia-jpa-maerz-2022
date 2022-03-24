package de.atruvia.springdemo.de.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TinyCustomerUmsatz {

    private final String companyName;
    private final BigDecimal umsatz;
}
