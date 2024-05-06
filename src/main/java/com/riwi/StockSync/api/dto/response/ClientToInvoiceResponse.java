package com.riwi.StockSync.api.dto.response;

import java.util.List;

import com.riwi.StockSync.domain.entities.Invoice;
import com.riwi.StockSync.util.enums.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientToInvoiceResponse {
    
    private String id;
    private String name;
    private String mail;
    private String phone;
    private DocumentType documentType;
    private List<Invoice> invoices;

}
