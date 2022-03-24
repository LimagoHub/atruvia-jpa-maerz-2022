package de.atruvia.springdemo.de.repositories.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", productName='").append(productName).append('\'');
        sb.append(", supplierID=").append(supplierID);
        sb.append(", categoryID=").append(categoryID);
        sb.append(", quantityPerUnit='").append(quantityPerUnit).append('\'');
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", unitsInStock=").append(unitsInStock);
        sb.append(", unitsOnOrder=").append(unitsOnOrder);
        sb.append(", reorderLevel=").append(reorderLevel);
        sb.append(", discontinued=").append(discontinued);
        sb.append('}');
        return sb.toString();
    }
}