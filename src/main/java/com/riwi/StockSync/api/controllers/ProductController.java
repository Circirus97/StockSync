package com.riwi.StockSync.api.controllers;


import com.riwi.StockSync.api.dto.errors.ErrorResponse;
import com.riwi.StockSync.api.dto.request.ProductRequest;
import com.riwi.StockSync.api.dto.response.ProductToInventaryResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "List all existing products in a inventory",
            description = "Brings all existing products in an inventory"
    )
    @GetMapping
    public ResponseEntity<Page<ProductToInventaryResponse>>getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size){

        return ResponseEntity.ok(this.productService.getAll(page-1, size));
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
            summary = "Show the product that belongs to that id.",
            description = "Retrieve the product that belongs to that id.."
    )
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductToInventaryResponse> getById(
            @PathVariable Long id){

        return ResponseEntity.ok(this.productService.getById(id));
    }


    @Operation(
            summary = "Create a product.",
            description = "Create a product for a specific inventory requiring the following data: inventory id, product name, product price, product size and product color."
    )
    @PostMapping
    public ResponseEntity<ProductToInventaryResponse> insert(
            @RequestBody ProductRequest product){

        return ResponseEntity.ok(this.productService.create(product));
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
            summary = "Delete a product.",
            description = "Delete a specific product by passing its id."
    )
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ){
        this.productService.delete(id);
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
            summary = "Update a product.",
            description = "Update a specific product by passing its id and returning the updated product."
    )
    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductToInventaryResponse> update(
            @PathVariable Long id,
            @RequestBody ProductRequest product
    ){
        return ResponseEntity.ok(this.productService.update(product, id));
    }
}
