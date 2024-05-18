package com.riwi.StockSync.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventaryToStoreResponse {

    private String id;
    private LocalDateTime dateTime;
    private StoreResponse store;
    private ProductResponse product;

}
