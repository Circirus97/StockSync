package com.riwi.StockSync.domain.repositories;

import com.riwi.StockSync.domain.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients,String>{
    
}
