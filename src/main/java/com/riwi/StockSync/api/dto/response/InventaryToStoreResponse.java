package com.riwi.StockSync.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventaryToStoreResponse {

    private String id;
    private LocalDate date;

    private StoreResponse store;
    private ProductResponse product;

}
