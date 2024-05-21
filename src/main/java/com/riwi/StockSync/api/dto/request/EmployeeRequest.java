package com.riwi.StockSync.api.dto.request;

import com.riwi.StockSync.util.message.ErrorMessage;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = ErrorMessage.MaxCharacters15)
    private String identity;
    @NotBlank
    private String contact;
    private String storeId;

}
