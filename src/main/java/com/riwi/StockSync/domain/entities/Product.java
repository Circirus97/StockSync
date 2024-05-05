package com.riwi.StockSync.domain.entities;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue
    private String Id;

    @Column(length = 255, nullable = false)
    private String name;

    private BigInteger price;

    @Column(length = 255, nullable = false)
    private String size;

    @Column(length = 255, nullable = false)
    private String color;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="colum_id",referencedColumnName = "id")
    private Inventary inventary;


    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Item> items;


}
