package com.riwi.StockSync.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.StockSync.api.dto.request.StoreRequest;
import com.riwi.StockSync.api.dto.response.StoreResponse;
import com.riwi.StockSync.infrastructure.services.interfaces.IStoreService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/store")
@AllArgsConstructor

public class StoreController {

    @Autowired
    private final IStoreService storeService;

    @GetMapping
    // como es paginacion recibe 2 parametros pagina y size, con los requestparam lo que digo al programa es que si no me dan los valores los pase por defecto
    public ResponseEntity<Page<StoreResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size){
            return ResponseEntity.ok(this.storeService.getAll(page-1, size));

    }

    @GetMapping(path="/{id}")
    public ResponseEntity<StoreResponse> get(
        @PathVariable String id
    ){
        return ResponseEntity.ok(this.storeService.getById(id));
    }


    @PostMapping
    public ResponseEntity<StoreResponse> create(
        
        @RequestBody StoreRequest store
    ){
        return ResponseEntity.ok(this.storeService.create(store));

    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable String id
    ){
        this.storeService.delete(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping(path="/{id}")

    public ResponseEntity<StoreResponse> update(
        @PathVariable String id,
        @RequestBody StoreRequest store
    ){
        return ResponseEntity.ok(this.storeService.update(store, id));
    }
    
    
}
