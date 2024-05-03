package com.riwi.StockSync.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeResponse {

    private String id;
    private String name;
    private String identity;
    private String contact;
    private StoreToEmployeeResponse store;

    
}