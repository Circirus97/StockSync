package com.riwi.StockSync.domain.repositories;

import com.riwi.StockSync.domain.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
    
}
