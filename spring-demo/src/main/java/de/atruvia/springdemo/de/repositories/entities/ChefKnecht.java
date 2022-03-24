package de.atruvia.springdemo.de.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder

public class ChefKnecht {

    private  String chef;
    private  String knecht;
}
