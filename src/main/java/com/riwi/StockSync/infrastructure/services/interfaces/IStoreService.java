package com.riwi.StockSync.infrastructure.services.interfaces;

import com.riwi.StockSync.api.dto.request.StoreRequest;
import com.riwi.StockSync.api.dto.response.StoreResponse;

public interface IStoreService extends CrudServices <StoreRequest, StoreResponse,String> {
    
}
