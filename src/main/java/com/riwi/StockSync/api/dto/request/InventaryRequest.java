package com.riwi.StockSync.api.dto.request;

import com.riwi.StockSync.util.message.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = ErrorMessage.RequiredDateTime)
    private LocalDateTime dateTime;
    private String storeId;


    //private List<ProductRequest> productList;


}
