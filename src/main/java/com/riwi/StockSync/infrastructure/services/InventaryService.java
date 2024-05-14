package com.riwi.StockSync.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi.StockSync.api.dto.request.InventaryRequest;
import com.riwi.StockSync.api.dto.response.InventaryToStoreResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IInventaryService;



public class InventaryService  implements IInventaryService{

    @Override
    public Page<InventaryToStoreResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public InventaryToStoreResponse create(InventaryRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public InventaryToStoreResponse update(InventaryRequest request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public InventaryToStoreResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

   
}
