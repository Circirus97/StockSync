package com.riwi.StockSync.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.StockSync.domain.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
