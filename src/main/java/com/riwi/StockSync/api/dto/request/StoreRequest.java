package com.riwi.StockSync.api.dto.request;

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

public class StoreRequest {

    private String id;
    @Size(min = 0, max =40, message = "the name must have a maximum of 40 characters")
    @NotBlank(message = "store name is required")
    private String name;
    private String location;
    
}
