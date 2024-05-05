package com.riwi.StockSync.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi.StockSync.api.dto.response.ProductToInventaryResponse;
import com.riwi.StockSync.infrastructure.services.interfaces.IProductService;


public class ProductService implements IProductService {

    @Override
    public Page<ProductToInventaryResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ProductToInventaryResponse create(com.riwi.StockSync.api.dto.request.ProductRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ProductToInventaryResponse update(com.riwi.StockSync.api.dto.request.ProductRequest request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ProductToInventaryResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    
}
