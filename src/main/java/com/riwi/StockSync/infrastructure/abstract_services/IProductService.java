package com.riwi.StockSync.infrastructure.abstract_services;

import com.riwi.StockSync.api.dto.request.ProductRequest;
import com.riwi.StockSync.api.dto.response.ProductToInventaryResponse;

public interface IProductService extends CrudServices<ProductRequest, ProductToInventaryResponse, String> {
    
}
