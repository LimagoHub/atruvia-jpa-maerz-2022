package de.atruvia.springdemo.de.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", nullable = false)
    private Integer id;

    @Column(name = "Productname", nullable = false, length = 40)
    private String productName;


    @ManyToOne
    @JoinColumn(name = "Supplierid")
    private Supplier supplierID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Categoryid")
    private Category categoryID;

    @Column(name = "Quantityperunit", length = 20)
    private String quantityPerUnit;

    @Column(name = "Unitprice", precision = 10, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "Unitsinstock")
    private Integer unitsInStock;

    @Column(name = "Unitsonorder")
    private Integer unitsOnOrder;

    @Column(name = "Reorderlevel")
    private Integer reorderLevel;

    @Column(name = "Discontinued", nullable = false)
    private Boolean discontinued = false;

}