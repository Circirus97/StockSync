package com.riwi.StockSync.infrastructure.services;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.StockSync.api.dto.request.ItemRequest;
import com.riwi.StockSync.api.dto.response.ItemResponseCompleteInformation;
import com.riwi.StockSync.domain.entities.Invoice;
import com.riwi.StockSync.domain.entities.Item;
import com.riwi.StockSync.domain.entities.Product;
import com.riwi.StockSync.domain.repositories.InvoiceRepository;
import com.riwi.StockSync.domain.repositories.ItemRepository;
import com.riwi.StockSync.domain.repositories.ProductRepository;
import com.riwi.StockSync.infrastructure.services.interfaces.IItemService;
import com.riwi.StockSync.util.exceptions.IdNotFoundExeption;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService{

    private final ItemRepository itemRepository;
    private final ProductRepository productRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    public Page<ItemResponseCompleteInformation> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        PageRequest pagination =PageRequest.of(page, size);

        return this.itemRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public ItemResponseCompleteInformation create(ItemRequest request) {
        Product product = this.productRepository.findById(request
        .getProduct_id()).orElseThrow(() -> new IdNotFoundExeption("Product"));

        Invoice invoice = this.invoiceRepository.findById(request
        .getInvoice_id()).orElseThrow(()-> new IdNotFoundExeption("Invoice"));

        Item item = this.requestToItem(request, new Item());
        item.setInvoice(invoice);
        item.setProduct(product);

        return this.entityToResponse(this.itemRepository.save(item));
    }

    @Override
    public ItemResponseCompleteInformation update(ItemRequest request, String id) {
        
        Item item = this.find(id);

        Product product = this.productRepository.findById(request
        .getProduct_id()).orElseThrow(() -> new IdNotFoundExeption("Product"));

        Invoice invoice = this.invoiceRepository.findById(request
        .getInvoice_id()).orElseThrow(()-> new IdNotFoundExeption("Invoice"));

        item =  this.requestToItem(request, item);

        item.setInvoice(invoice);
        item.setProduct(product);

        return this.entityToResponse(this.itemRepository.save(item));
    }

    @Override
    public void delete(String id) {
        Item item = this.find(id);
        this.itemRepository.delete(item);
    }

    @Override
    public ItemResponseCompleteInformation getById(String id) {
        return this.entityToResponse(this.find(id));
    }

    private ItemResponseCompleteInformation entityToResponse(Item item){
       ItemResponseCompleteInformation response = new ItemResponseCompleteInformation();
       
        BeanUtils.copyProperties(item, response);
        response.setInvoice(item.getInvoice());
        response.setProduct(item.getProduct());

        return response;
    }

    private Item find(String id){
        return this.itemRepository.findById(id).orElseThrow(() -> new IdNotFoundExeption("Items"));
    }

    private Item requestToItem(ItemRequest request, Item item){
        BeanUtils.copyProperties(request, item);
        return item;
    }
}
