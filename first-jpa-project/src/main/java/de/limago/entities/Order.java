package de.limago.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID")
    private Customer customerID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID")
    private Employee employeeID;

    @Column(name = "Orderdate")
    private Instant orderDate;

    @Column(name = "Requireddate")
    private Instant requiredDate;

    @Column(name = "Shippeddate")
    private Instant shippedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipVia")
    private Shipper shipVia;

    @Column(name = "Freight", precision = 10, scale = 4)
    private BigDecimal freight;

    @Column(name = "Shipname", length = 40)
    private String shipName;

    @Column(name = "Shipaddress", length = 60)
    private String shipAddress;

    @Column(name = "Shipcity", length = 15)
    private String shipCity;

    @Column(name = "Shipregion", length = 15)
    private String shipRegion;

    @Column(name = "Shippostalcode", length = 10)
    private String shipPostalCode;

    @Column(name = "Shipcountry", length = 15)
    private String shipCountry;

}