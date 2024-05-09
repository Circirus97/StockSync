package com.riwi.StockSync.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductToInventaryResponse {

    private String Id;
    private String name;
    private BigInteger price;
    private String size;
    private String color;

    private InventaryResponse inventary;
    private ItemResponse item;
}
