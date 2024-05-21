package com.riwi.StockSync.domain.repositories;

import com.riwi.StockSync.domain.entities.Inventary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventaryRepository extends JpaRepository<Inventary, String> {
    
}
