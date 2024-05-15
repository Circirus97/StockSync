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

public class StoreRequest {

    private String id;
    @Size(min = 0, max =40, message = ErrorMessage.MaxCharacters40)
    @NotBlank(message = ErrorMessage.RequiredName)
    private String name;
    @NotBlank (message = ErrorMessage.RequiredLocation)
    private String location;
    
}
