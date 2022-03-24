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
@Table(name = "`order details`")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @MapsId("orderID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Orderid", nullable = false)
    @ToString.Exclude
    private Order orderID;

    @MapsId("productID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Productid", nullable = false)
    @ToString.Exclude
    private Product productID;

    @Column(name = "Unitprice", nullable = false, precision = 10, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Discount", nullable = false, precision = 8)
    private BigDecimal discount;

    @Transient
    public BigDecimal getTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

}