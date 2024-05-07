package com.riwi.StockSync.domain.entities;

import java.util.List;

import com.riwi.StockSync.util.enums.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 90, nullable = false)
    private String email;

    @Column(length = 11, nullable = false)
    private int phoneNumber;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(length = 11, nullable = false)
    private int documentNumber;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Invoice> invoices;

}
