package com.riwi.StockSync.api.dto.request;

import com.riwi.StockSync.util.message.ErrorMessage;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String id;
    @NotBlank(message = ErrorMessage.RequiredName)
    private String name;
    @NotNull(message = ErrorMessage.MaxCharacters15)
    private String identity;
    @NotNull
    private String contact;
    private String storeId;

}
