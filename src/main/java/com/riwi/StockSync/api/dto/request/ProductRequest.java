package com.riwi.StockSync.api.dto.request;

import com.riwi.StockSync.util.message.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = ErrorMessage.RequiredName)
    private String name;
    @NotNull(message = ErrorMessage.RequiredPrice)
    private BigInteger price;
    @NotBlank(message = ErrorMessage.RequiredSize)
    private String size;
    @NotBlank(message = ErrorMessage.RequiredColor)
    private String color;
    @NotNull(message = ErrorMessage.RequiredStock)
    private Integer stock;

    private String inventaryId;

    //private List<ItemRequest>itemList;

}
