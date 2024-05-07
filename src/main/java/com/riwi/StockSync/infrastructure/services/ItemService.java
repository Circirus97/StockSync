package com.riwi.StockSync.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.StockSync.api.dto.response.ItemResponse;
import com.riwi.StockSync.api.dto.response.ItemResponseCompleteInformation;
import com.riwi.StockSync.domain.entities.Item;
import com.riwi.StockSync.domain.repositories.ItemRepository;
import com.riwi.StockSync.infrastructure.services.interfaces.IItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService{

    private final ItemRepository itemRepository;

    @Override
    public Page<ItemResponseCompleteInformation> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        PageRequest pagination =PageRequest.of(page, size);

        return this.itemRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public ItemResponseCompleteInformation create(ItemResponse request) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ItemResponseCompleteInformation update(ItemResponse request, String id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ItemResponseCompleteInformation getById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    private ItemResponseCompleteInformation entityToResponse(Item item){
       ItemResponseCompleteInformation response = new ItemResponseCompleteInformation();
       
        BeanUtils.copyProperties(item, response);
        response.setInvoice(item.getInvoice());
        response.setProduct(item.getProduct());

        return response;
    }
}
