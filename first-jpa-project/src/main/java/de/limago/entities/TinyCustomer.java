package de.limago.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TinyCustomer {

    private final String companyName;
    private final String city;
}
