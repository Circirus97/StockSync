package com.riwi.StockSync.api.dto.response;

import com.riwi.StockSync.util.enums.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {
    
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private DocumentType documentType;
    private int documentNumber;
}
