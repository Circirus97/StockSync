package com.riwi.StockSync.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.StockSync.api.dto.request.ItemRequest;
import com.riwi.StockSync.api.dto.response.ItemResponseCompleteInformation;
import com.riwi.StockSync.infrastructure.abstract_services.IItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/items")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final IItemService iItemService;

    @GetMapping
    public ResponseEntity<Page<ItemResponseCompleteInformation>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
                return ResponseEntity.ok(this.iItemService.getAll(page,size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemResponseCompleteInformation> getById(@PathVariable String id){
        return ResponseEntity.ok(this.iItemService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ItemResponseCompleteInformation> create(@RequestBody ItemRequest entity) {
        
        return ResponseEntity.ok(this.iItemService.create(entity));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ItemResponseCompleteInformation>update(@PathVariable String id, @RequestBody ItemRequest item){
        return ResponseEntity.ok(this.iItemService.update(item, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.iItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
