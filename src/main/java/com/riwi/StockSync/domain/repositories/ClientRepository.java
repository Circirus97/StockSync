package com.riwi.StockSync.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.StockSync.domain.entities.Clients;

@Repository
public interface ClientRepository extends JpaRepository<Clients,String>{
    
}
