package com.riwi.StockSync.infrastructure.services.interfaces;

import com.riwi.StockSync.api.dto.request.EmployeeRequest;
import com.riwi.StockSync.api.dto.response.EmployeeResponse;

public interface IEmployeeService extends CrudServices<EmployeeRequest,EmployeeResponse, String> {
    
}
