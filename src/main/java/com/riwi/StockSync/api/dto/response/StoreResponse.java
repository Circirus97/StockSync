package com.riwi.StockSync.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StoreResponse {
    
    private String id;
    private String name;
    private String location;
    private List<EmployeeToStoreResponse> employees;
}
