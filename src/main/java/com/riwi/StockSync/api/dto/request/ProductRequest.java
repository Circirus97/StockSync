package com.riwi.StockSync.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {


    private Long id;
    private String name;
    private BigInteger price;
    private String size;
    private String color;
    private Integer stock;

    private String inventaryId;

    //private List<ItemRequest>itemList;

}
