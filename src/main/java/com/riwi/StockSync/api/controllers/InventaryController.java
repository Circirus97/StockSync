package com.riwi.StockSync.api.controllers;


import com.riwi.StockSync.api.dto.errors.ErrorResponse;
import com.riwi.StockSync.api.dto.request.InventaryRequest;
import com.riwi.StockSync.api.dto.response.InventaryToStoreResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IInventaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventary")
@RequiredArgsConstructor
@Tag(name = "Inventaries")
public class InventaryController {

    @Autowired
    private final IInventaryService inventaryService;


    @Operation(
            summary = "List all existing inventories in a store",
            description = "Retrieve all inventories related to a store along with their information (name, location)."
    )
    @GetMapping
    public ResponseEntity<Page<InventaryToStoreResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size){
        return ResponseEntity.ok(this.inventaryService.getAll(page-1, size));

    }


    @ApiResponse(
            responseCode = "400",
            description = "The id is not valid",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            }
    )
    @Operation(
            summary = "Show the inventory that belongs to that id.",
            description = "Retrieve the inventory related to a store."
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<InventaryToStoreResponse> getById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(this.inventaryService.getById(id));
    }


    @Operation(
            summary = "Create an inventory.",
            description = "Create an inventory for a specific store requiring the following data: store id and creation date."
    )
    @PostMapping
    public ResponseEntity<InventaryToStoreResponse> insert(
            @RequestBody InventaryRequest inventary
    ){
        return ResponseEntity.ok(this.inventaryService.create(inventary));
    }


    @ApiResponse(
            responseCode = "400",
            description = "The id is not valid",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            }
    )
    @Operation(
            summary = "Delete an inventory.",
            description = "Delete a specific inventory by passing its id."
    )
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id
    ){
        this.inventaryService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @ApiResponse(
            responseCode = "400",
            description = "The id is not valid",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            }
    )
    @Operation(
            summary = "Update an inventory.",
            description = "Update a specific inventory by passing its id and returning the updated inventory."
    )
    @PutMapping(path = "/{id}")
    public ResponseEntity<InventaryToStoreResponse>update(
            @PathVariable String id,
            @RequestBody InventaryRequest inventary
    ){
        return  ResponseEntity.ok(this.inventaryService.update(inventary, id));
    }


}

