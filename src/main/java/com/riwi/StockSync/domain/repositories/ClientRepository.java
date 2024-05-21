package com.riwi.StockSync.domain.repositories;

import com.riwi.StockSync.domain.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Clients,String>{

    Optional<Clients> findByDocumentNumber(int documentNumber);


}
