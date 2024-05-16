package com.riwi.StockSync.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    
    private String id;
    private int quantity;    
    private String invoice_id;
    private Long product_id;
}
