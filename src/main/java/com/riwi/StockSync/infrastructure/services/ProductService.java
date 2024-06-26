package com.riwi.StockSync.infrastructure.services;

import com.riwi.StockSync.api.dto.request.ProductRequest;
import com.riwi.StockSync.api.dto.response.InventaryResponse;
import com.riwi.StockSync.api.dto.response.ProductToInventaryResponse;
import com.riwi.StockSync.domain.entities.Inventary;
import com.riwi.StockSync.domain.entities.Product;
import com.riwi.StockSync.domain.repositories.InventaryRepository;
import com.riwi.StockSync.domain.repositories.ProductRepository;
import com.riwi.StockSync.infrastructure.abstract_services.IProductService;
import com.riwi.StockSync.util.exceptions.BadRequestExeption;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {


    @Autowired
    private final ProductRepository productRepository;
    private final InventaryRepository inventaryRepository;


    @Override
    public Page<ProductToInventaryResponse> getAll(int page, int size) {
        if(page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.productRepository.findAll(pagination).map(this::entityToResponse);

    }

    @Override
    public ProductToInventaryResponse create(ProductRequest request) {

        Inventary inventary = this.inventaryRepository.findById(request.getInventaryId()).orElseThrow(() -> new BadRequestExeption("inventary"));

        Product product = this.requestToProduct(request, new Product());
        product.setInventary(inventary);

        return this.entityToResponse(this.productRepository.save(product));
    }

    @Override
    public ProductToInventaryResponse update(ProductRequest request, Long id) {
        Product productToUpdate = this.find(id);

        Product product = this.requestToEntity(request, productToUpdate);
        return this.entityToResponse(this.productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        Product product = this.find(id);
        this.productRepository.delete(product);
    }

    @Override
    public ProductToInventaryResponse getById(Long id) {
        Product product = this.find(id);
        return  this.entityToResponse(product);
    }


    private ProductToInventaryResponse entityToResponse(Product entity){

        ProductToInventaryResponse response = new ProductToInventaryResponse();
        BeanUtils.copyProperties(entity, response);
        InventaryResponse inventaryDto = new InventaryResponse();
        BeanUtils.copyProperties(entity.getInventary(), inventaryDto);
        response.setInventary(inventaryDto);

        return response;
    }

    private Product requestToProduct(ProductRequest request, Product entity){
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setSize(request.getSize());
        entity.setColor(request.getColor());
        entity.setStock(request.getStock());

        return entity;

    }

    private Product requestToEntity(ProductRequest entity, Product product){
        product.setName(entity.getName());
        product.setPrice(entity.getPrice());
        product.setSize(entity.getSize());
        product.setColor(entity.getColor());
        product.setStock(entity.getStock());

        return product;
    }

    private Product find(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new BadRequestExeption("product"));
    }

}