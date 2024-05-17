package com.riwi.StockSync.domain.entities;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(nullable = false)
    private BigInteger price;

    @Column(length = 255, nullable = false)
    private String size;

    @Column(length = 255, nullable = false)
    private String color;

    @Column(nullable = false)
    private Integer stock;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="colum_id",referencedColumnName = "id")
    private Inventary inventary;


    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Item> items;


}
