package com.riwi.StockSync.api.controllers;

import com.riwi.StockSync.api.dto.errors.ErrorResponse;
import com.riwi.StockSync.api.dto.request.StoreRequest;
import com.riwi.StockSync.api.dto.response.StoreToEmployeeResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/store")
@AllArgsConstructor

public class StoreController {

    @Autowired
    private final IStoreService storeService;
    @Operation(summary ="Gets the paginated list of all stores")
    @GetMapping
    // como es paginacion recibe 2 parametros pagina y size, con los requestparam lo que digo al programa es que si no me dan los valores los pase por defecto
    public ResponseEntity<Page<StoreToEmployeeResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size){
            return ResponseEntity.ok(this.storeService.getAll(page-1, size));

    }
    @Operation(summary ="Displays the information of an store"
    , description = "Requesting  unique Id, responds with the id, name and location")
     @ApiResponse(responseCode = "400", description = "When the entered Id is not valid", content = {
        @Content(mediaType="application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @GetMapping(path="/{id}")
    public ResponseEntity<StoreToEmployeeResponse> get(
        @PathVariable String id
    ){
        return ResponseEntity.ok(this.storeService.getById(id));
    }


    @Operation(summary ="Insert a new store", 
    description =  "Request for body name and location")
    @PostMapping
    public ResponseEntity<StoreToEmployeeResponse> create(
        @Validated
        @RequestBody StoreRequest store
    ){
        return ResponseEntity.ok(this.storeService.create(store));

    }
    @Operation(summary ="Delete an store",
    description = "Requires the store's unique ID")
    @ApiResponse(responseCode = "400", description = "When the entered Id is not valid", content = {
        @Content(mediaType="application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable String id
    ){
        this.storeService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary ="Edits an store",
    description ="Requires the store's unique ID and prompts for body name and location")
   @PutMapping(path="/{id}")

    public ResponseEntity<StoreToEmployeeResponse> update(
        @PathVariable String id,
        @Validated
        @RequestBody StoreRequest store
    ){
        return ResponseEntity.ok(this.storeService.update(store, id));
    }
    
    
}
