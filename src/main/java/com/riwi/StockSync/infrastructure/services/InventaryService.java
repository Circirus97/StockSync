package com.riwi.StockSync.infrastructure.services;


import com.riwi.StockSync.api.dto.request.InventaryRequest;
import com.riwi.StockSync.api.dto.response.InventaryToStoreResponse;
import com.riwi.StockSync.api.dto.response.ProductResponse;
import com.riwi.StockSync.api.dto.response.StoreResponse;
import com.riwi.StockSync.domain.entities.Inventary;
import com.riwi.StockSync.domain.entities.Product;
import com.riwi.StockSync.domain.entities.Store;
import com.riwi.StockSync.domain.repositories.InventaryRepository;
import com.riwi.StockSync.domain.repositories.StoreRepository;
import com.riwi.StockSync.infrastructure.abstract_services.IInventaryService;
import com.riwi.StockSync.util.exceptions.BadRequestExeption;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class InventaryService  implements IInventaryService {


    @Autowired
    private final InventaryRepository inventaryRepository;

    @Autowired
    private final StoreRepository storeRepository;

    @Override
    public Page<InventaryToStoreResponse> getAll(int page, int size) {
        if(page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.inventaryRepository.findAll(pagination).map(this::entityToResponse);

    }

    @Override
    public InventaryToStoreResponse create(InventaryRequest request) {
        Store store = this.storeRepository.findById(request.getStoreId()).orElseThrow(() -> new BadRequestExeption("store"));

        Inventary inventary = this.requestToEntity(request, new Inventary());
        inventary.setStore(store);

        return this.entityToResponse(this.inventaryRepository.save(inventary));
    }

    @Override
    public InventaryToStoreResponse update(InventaryRequest request, String id) {
        Inventary inventaryToUpdate = this.find(id);

        Inventary inventary = this.requestToEntity(request, inventaryToUpdate);
        return this.entityToResponse(this.inventaryRepository.save(inventary));

    }

    @Override
    public void delete(String id) {
        Inventary inventary = this.find(id);
        this.inventaryRepository.delete(inventary);
    }

    @Override
    public InventaryToStoreResponse getById(String id) {
        Inventary inventary = this.find(id);
        return  this.entityToResponse(inventary);

    }

    private InventaryToStoreResponse entityToResponse(Inventary entity){

        InventaryToStoreResponse response = new InventaryToStoreResponse();
        BeanUtils.copyProperties(entity, response);
        StoreResponse storeDto = new StoreResponse();
        BeanUtils.copyProperties(entity.getStore(), storeDto);


        List<ProductResponse> productDto = new ArrayList<>();
        for (Product product : entity.getProducts()) {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(product, productResponse);
            productDto.add(productResponse);
        }

        response.setProduct(productDto);
        response.setStore(storeDto);



    List<ProductResponse> productDto = new ArrayList<>();
    for (Product product : entity.getProducts()) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        productDto.add(productResponse);
    }


    private Inventary requestToEntity(InventaryRequest request, Inventary inventary){
        BeanUtils.copyProperties(request, inventary);


        response.setProduct(productDto);
        response.setStore(storeDto);

        return response;
    }

    private Inventary requestToEntity(InventaryRequest request, Inventary inventary){
        BeanUtils.copyProperties(request, inventary);


        // inventary.setDateTime(request.getDateTime());

        return inventary;
    }


    private Inventary find(String id){
        return this.inventaryRepository.findById(id).orElseThrow(() -> new BadRequestExeption("inventary"));
    }


}