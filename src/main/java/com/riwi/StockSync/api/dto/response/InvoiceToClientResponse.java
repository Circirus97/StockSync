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
public class InvoiceToClientResponse {

    private String name;
    private String email;
    private String phone;
    private DocumentType documentType;
    private int documentNumber;
}
