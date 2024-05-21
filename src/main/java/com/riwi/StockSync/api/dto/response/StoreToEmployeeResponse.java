package com.riwi.StockSync.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StoreToEmployeeResponse {
    
    private String id;
    private String name;
    private String location;
    private List<EmployeeResponse> employees;
}
