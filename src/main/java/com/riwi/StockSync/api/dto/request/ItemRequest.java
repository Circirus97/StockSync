package com.riwi.StockSync.api.dto.request;

import com.riwi.StockSync.util.message.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 1)
    private int quantity;    
    @NotBlank(message = ErrorMessage.RequiredId)
    private String invoice_id;
    @NotBlank(message = ErrorMessage.RequiredId)
    private Long product_id;
}
