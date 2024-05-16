package com.riwi.StockSync.api.controllers;

import com.riwi.StockSync.api.dto.errors.ErrorResponse;
import com.riwi.StockSync.api.dto.request.InvoiceRequest;
import com.riwi.StockSync.api.dto.response.InvoiceCompleteInfoResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IInvoiceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary ="Gets the paginated list of all invoices")
    @GetMapping
    public ResponseEntity<Page<InvoiceCompleteInfoResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        return ResponseEntity.ok(this.iInvoiceService.getAll(page -1, size));
    }

    @Operation(summary ="Insert a new invoce", 
    description =  "Request for body date, totalPurchases, employeeId, clientId, storeId, itemList")
    @PostMapping
    public ResponseEntity<InvoiceCompleteInfoResponse> insert(
            @Validated
            @RequestBody
            InvoiceRequest invoice
    ){
        return ResponseEntity.ok(this.iInvoiceService.create(invoice));
    }

    @Operation(summary ="Displays the information of an invoce"
    , description = "Requires the unique invoice ID, responds with id, date, total, store data, employee data, customer data and list of products.")
     @ApiResponse(responseCode = "400", description = "When the entered Id is not valid", content = {
        @Content(mediaType="application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<InvoiceCompleteInfoResponse> get(@PathVariable String id){
        return ResponseEntity.ok(this.iInvoiceService.getById(id));
    }


    @Operation(summary ="Delete an invoce",
    description = "Requires the invoce's unique ID")
    @ApiResponse(responseCode = "400", description = "When the entered Id is not valid", content = {
        @Content(mediaType="application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable String id){

        Map<String, String> response = new HashMap<>();

        response.put("message", "Invoice successfully deleted");

        this.iInvoiceService.delete(id);

        return ResponseEntity.ok(response);
    }


    @Operation(summary ="Edits an invoce",
    description ="Requires the invoce's unique ID and prompts for body date, totalPurchases, employeeId, clientId, storeId, itemList")
    @PutMapping(path = "/{id}")
    public ResponseEntity<InvoiceCompleteInfoResponse> update(
            @Validated
            @PathVariable String id,
            @RequestBody InvoiceRequest invoice
    ){
        return ResponseEntity.ok(this.iInvoiceService.update(invoice, id));
    }
}
