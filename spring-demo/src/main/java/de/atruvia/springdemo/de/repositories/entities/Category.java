package de.atruvia.springdemo.de.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID", nullable = false)
    private Integer id;

    @Column(name = "Categoryname", nullable = false, length = 15)
    private String categoryName;

    @Lob
    @Column(name = "Description")
    private String description;

    @ToString.Exclude
    @Column(name = "Picture")
    private byte[] picture;

    @OneToMany(mappedBy = "categoryID", cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();
}