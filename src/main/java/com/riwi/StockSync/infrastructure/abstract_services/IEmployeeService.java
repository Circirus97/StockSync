package com.riwi.StockSync.infrastructure.abstract_services;

import com.riwi.StockSync.api.dto.request.EmployeeRequest;
import com.riwi.StockSync.api.dto.response.EmployeeToStoreResponse;

public interface IEmployeeService extends CrudServices<EmployeeRequest, EmployeeToStoreResponse, String> {
    
}
