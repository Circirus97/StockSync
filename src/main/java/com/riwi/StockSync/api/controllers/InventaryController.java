package com.riwi.StockSync.api.controllers;


import com.riwi.StockSync.api.dto.request.InventaryRequest;
import com.riwi.StockSync.api.dto.response.InventaryToStoreResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IInventaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventary")
@RequiredArgsConstructor
public class InventaryController {

    @Autowired
    private final IInventaryService inventaryService;


    @GetMapping
    public ResponseEntity<Page<InventaryToStoreResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size){
        return ResponseEntity.ok(this.inventaryService.getAll(page-1, size));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InventaryToStoreResponse>get (
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.inventaryService.getById(id));
    }


    @PostMapping
    public ResponseEntity<InventaryToStoreResponse> insert(
            @RequestBody InventaryRequest inventary
    ){
        return ResponseEntity.ok(this.inventaryService.create(inventary));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ){
        this.inventaryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<InventaryToStoreResponse>update(
            @PathVariable String id,
            @RequestBody InventaryRequest inventary
    ){
        return  ResponseEntity.ok(this.inventaryService.update(inventary, id));
    }


}

