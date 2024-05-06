package com.riwi.StockSync.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi.StockSync.api.dto.response.ItemResponse;
import com.riwi.StockSync.api.dto.response.ItemResponseCompleteInformation;
import com.riwi.StockSync.infrastructure.services.interfaces.IItemService;

public class ItemService implements IItemService{

    @Override
    public Page<ItemResponseCompleteInformation> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public ItemResponseCompleteInformation create(ItemResponse request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ItemResponseCompleteInformation update(ItemResponse request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ItemResponseCompleteInformation getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
}
