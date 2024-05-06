package com.riwi.StockSync.api.dto.response;

import com.riwi.StockSync.domain.entities.Invoice;
import com.riwi.StockSync.domain.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseCompleteInformation {
    private String id;
    private int quantity;    
    private Invoice invoice;
    private Product product;

}
