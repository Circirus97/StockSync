package com.riwi.StockSync.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;


@Entity(name = "inventaries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventary {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @DateTimeFormat
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="colum_id",referencedColumnName = "id")
    private Store store;
    

    @OneToMany(mappedBy = "inventary", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Product> products;



}