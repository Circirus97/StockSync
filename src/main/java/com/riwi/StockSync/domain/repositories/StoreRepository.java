package com.riwi.StockSync.domain.repositories;

import com.riwi.StockSync.domain.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository <Store, String> {

}
