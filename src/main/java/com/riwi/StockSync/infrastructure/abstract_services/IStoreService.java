package com.riwi.StockSync.infrastructure.abstract_services;

import com.riwi.StockSync.api.dto.request.StoreRequest;
import com.riwi.StockSync.api.dto.response.StoreToEmployeeResponse;

public interface IStoreService extends CrudServices<StoreRequest, StoreToEmployeeResponse,String> {
    
}
