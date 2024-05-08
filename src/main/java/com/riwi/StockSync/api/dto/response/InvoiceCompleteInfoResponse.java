package com.riwi.StockSync.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCompleteInfoResponse {

    private String id;

    private LocalDate date;

    private Double totalPurchases;

    private StoreToInvoiceResponse store;

    private EmployeeToStoreResponse employee;

    private InvoiceToClientResponse client;

    private List<ItemResponse> itemList;

}
