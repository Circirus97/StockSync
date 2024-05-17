package com.riwi.StockSync.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventaryRequest {

    private String id;
    private LocalDateTime dateTime;
    private String storeId;


    //private List<ProductRequest> productList;


}
