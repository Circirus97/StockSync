package com.riwi.StockSync.api.dto.request;

import com.riwi.StockSync.util.enums.DocumentType;
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
public class ClientRequest {
    
    @NotBlank(message = ErrorMessage.RequiredName)
    @Size(max = 100)
    private String name;
    @Size(max = 150)
    private String email;
    @NotBlank(message = ErrorMessage.RequiredPhone)
    @Size(max = 11, min = 10)
    private String phoneNumber;
    @NotBlank(message = ErrorMessage.RequiredDocumentType)
    private DocumentType documentType;
    @NotBlank(message = ErrorMessage.RequiredDocumentNumeber)
    private int documentNumber;
}

