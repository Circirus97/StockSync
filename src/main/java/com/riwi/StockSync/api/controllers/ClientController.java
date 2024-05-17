package com.riwi.StockSync.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/clients")
@RequiredArgsConstructor
@Tag(name = "Clients")
public class ClientController {
    
    @Autowired
    private final IClientService clientService;
    
    @GetMapping
    @Operation(summary = "List all the clients with invoices",
            description = "Bring all the clients with the invoices and make a pagination of 3 clients" )
    public ResponseEntity<Page<ClientToInvoiceResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size){
            return ResponseEntity.ok(this.clientService.getAll(page, size));
        }

    @Operation(summary = "Create a new client",
        description = "Create a new client with name, email, phone number, document number and type" )
    @PostMapping
    public ResponseEntity<ClientToInvoiceResponse> create(@Validated @RequestBody ClientRequest client){
        return  ResponseEntity.ok(this.clientService.create(client));
    }

    @Operation(summary = "List a client with invoices",
            description = "Bring a client by giving an ID, each one of the clients have name, email, phone number, document number and type and invoices" )
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientToInvoiceResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(this.clientService.getById(id));
    }

    @Operation(summary = "Update a client ",
            description = "Update a client by giving an ID and you have to put name, email, phone number, document number and type" )
    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientToInvoiceResponse> update(@PathVariable String id,@Validated @RequestBody ClientRequest client){
        return ResponseEntity.ok(this.clientService.update(client, id));
    }

    @Operation(summary = "Delete a client ",
            description = "Delete a client by giving an unique ID" )
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
