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

import com.riwi.StockSync.api.dto.request.ClientRequest;
import com.riwi.StockSync.api.dto.response.ClientToInvoiceResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/clients")
@RequiredArgsConstructor
public class ClientController {
    
    @Autowired
    private final IClientService clientService;
    
    @GetMapping
    public ResponseEntity<Page<ClientToInvoiceResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size){
            return ResponseEntity.ok(this.clientService.getAll(page, size));
        }

    @PostMapping
    public ResponseEntity<ClientToInvoiceResponse> create(@RequestBody ClientRequest client){
        return  ResponseEntity.ok(this.clientService.create(client));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientToInvoiceResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(this.clientService.getById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientToInvoiceResponse> update(@PathVariable String id, @RequestBody ClientRequest client){
        return ResponseEntity.ok(this.clientService.update(client, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
