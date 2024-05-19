package com.riwi.StockSync.domain.repositories;

import com.riwi.StockSync.domain.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

    /*Optional<Invoice> findByClient(Clients client);*/
}
