package com.riwi.StockSync.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 40, nullable = false)
    private String identity;
    @Column(length = 15, nullable = false)
    private String contact;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="colum_id",referencedColumnName = "id")
    private Store store;

    /**
     * @OneToMany:
     * @ MapedBy: Debemos especificar en que propiedad se está mapeando en la otra
     * entidad
     * Cascade.All: Especificamos el tipo cascada, All quiere decir que tendrá todos
     * los tipos de cascada
     * orphanRemoval -> Espeficar que un objeto huerfano (sin llave foranea) sera
     * eliminado
     */

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Invoice> invoiceList;

    
}
