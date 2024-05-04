package com.riwi.StockSync.api.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCompleteInfoResponse {

    private String id;

    private LocalDate date;

    private Double totalPurchases;

    private StoreResponse store;

    private  EmployeeResponse employee;

/*    private ClientResponse client;

    private List<ItemResponse> itemList;*/

}
