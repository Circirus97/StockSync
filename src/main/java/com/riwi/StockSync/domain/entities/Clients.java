package com.riwi.StockSync.domain.entities;

import com.riwi.StockSync.util.enums.DocumentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
