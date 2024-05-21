package com.riwi.StockSync.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "stores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;


    @OneToMany(mappedBy = "store",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude

    private List<Employee>employee;


    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Invoice> invoices;













    
}
