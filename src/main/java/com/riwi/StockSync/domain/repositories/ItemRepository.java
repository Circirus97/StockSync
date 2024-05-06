package com.riwi.StockSync.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riwi.StockSync.domain.entities.Item;

public interface ItemRepository extends JpaRepository<Item, String> {
    
}
