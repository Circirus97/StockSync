package com.riwi.StockSync.api.controllers;

import com.riwi.StockSync.api.dto.request.EmployeeRequest;
import com.riwi.StockSync.api.dto.response.EmployeeToStoreResponse;
import com.riwi.StockSync.infrastructure.abstract_services.IEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final IEmployeeService employeeService;

    @Operation(summary ="Gets the list of paid employees")
    @GetMapping
    // como es paginacion recibe 2 parametros pagina y size, con los requestparam lo que digo al programa es que si no me dan los valores los pase por defecto
    public ResponseEntity<Page<EmployeeToStoreResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size){
            return ResponseEntity.ok(this.employeeService.getAll(page-1, size));

    }
    @Operation(summary ="Displays the information of an employee, requesting his or her unique id, responds with the id, name, identity, contact and all store data (id, name, location)")
    @GetMapping(path = "/{id}")
     public ResponseEntity<EmployeeToStoreResponse>get(
        @PathVariable String id
    ){
        return ResponseEntity.ok(this.employeeService.getById(id));
    }

    @Operation(summary ="Insert a new employee requesting: name, identity, contact and storeId")
    @PostMapping
    public ResponseEntity <EmployeeToStoreResponse> insert(
    
        @RequestBody EmployeeRequest employee
    ){
        return ResponseEntity.ok(this.employeeService.create(employee));

    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable String id
    ){
        this.employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }


     @PutMapping(path="/{id}")
    public ResponseEntity<EmployeeToStoreResponse> update(

        @PathVariable String id,
        @RequestBody EmployeeRequest employee
    ){
        return ResponseEntity.ok(this.employeeService.update(employee, id));
    }

    
}
