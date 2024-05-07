package com.riwi.StockSync.api.controllers;

import com.riwi.StockSync.api.dto.request.InvoiceRequest;
import com.riwi.StockSync.api.dto.response.InvoiceCompleteInfoResponse;
import com.riwi.StockSync.infrastructure.services.interfaces.IInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final IInvoiceService iInvoiceService;

    @GetMapping
    public ResponseEntity<Page<InvoiceCompleteInfoResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        return ResponseEntity.ok(this.iInvoiceService.getAll(page -1, size));
    }

    @PostMapping
    public ResponseEntity<InvoiceCompleteInfoResponse> insert(
            @Validated
            @RequestBody
            InvoiceRequest invoice
    ){
        return ResponseEntity.ok(this.iInvoiceService.create(invoice));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InvoiceCompleteInfoResponse> get(@PathVariable String id){
        return ResponseEntity.ok(this.iInvoiceService.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable String id){

        Map<String, String> response = new HashMap<>();

        response.put("message", "Invoice successfully deleted");

        this.iInvoiceService.delete(id);

        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<InvoiceCompleteInfoResponse> update(
            @Validated
            @PathVariable String id,
            @RequestBody InvoiceRequest invoice
    ){
        return ResponseEntity.ok(this.iInvoiceService.update(invoice, id));
    }
}
