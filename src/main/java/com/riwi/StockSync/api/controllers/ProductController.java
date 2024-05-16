package com.riwi.StockSync.api.controllers;


import com.riwi.StockSync.api.dto.request.ProductRequest;
import com.riwi.StockSync.api.dto.response.ProductToInventaryResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final IProductService productService;


    @GetMapping
    public ResponseEntity<Page<ProductToInventaryResponse>>getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size){

        return ResponseEntity.ok(this.productService.getAll(page-1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductToInventaryResponse> get (
            @PathVariable Long id){

        return ResponseEntity.ok(this.productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductToInventaryResponse> insert(
            @RequestBody ProductRequest product){

        return ResponseEntity.ok(this.productService.create(product));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductToInventaryResponse> update(
            @PathVariable Long id,
            @RequestBody ProductRequest product
    ){
        return ResponseEntity.ok(this.productService.update(product, id));
    }
}
