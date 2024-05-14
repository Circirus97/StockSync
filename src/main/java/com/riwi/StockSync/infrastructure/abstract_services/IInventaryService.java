package com.riwi.StockSync.infrastructure.abstract_services;

import com.riwi.StockSync.api.dto.request.InventaryRequest;
import com.riwi.StockSync.api.dto.response.InventaryToStoreResponse;


public interface IInventaryService extends CrudServices<InventaryRequest, InventaryToStoreResponse, String> {
    
}
