package com.riwi.StockSync.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {

    private String id;

    private LocalDate date;

    private Double totalPurchases;

    private String employeeId;

    private String clientId;

    /*private List<ItemRequest> itemList;*/
}
