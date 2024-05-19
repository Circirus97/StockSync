package com.riwi.StockSync.domain.repositories;

import com.riwi.StockSync.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
