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

import com.riwi.StockSync.api.dto.request.EmployeeRequest;
import com.riwi.StockSync.api.dto.response.EmployeeResponse;

import com.riwi.StockSync.infrastructure.services.interfaces.IEmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private final IEmployeeService employeeService;

    @GetMapping
    // como es paginacion recibe 2 parametros pagina y size, con los requestparam lo que digo al programa es que si no me dan los valores los pase por defecto
    public ResponseEntity<Page<EmployeeResponse>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size){
            return ResponseEntity.ok(this.employeeService.getAll(page-1, size));

    }

    @GetMapping(path = "/{id}")
     public ResponseEntity<EmployeeResponse>get(
        @PathVariable String id
    ){
        return ResponseEntity.ok(this.employeeService.getById(id));
    }


    @PostMapping
    public ResponseEntity <EmployeeResponse> insert(
    
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
    public ResponseEntity<EmployeeResponse> update(

        @PathVariable String id,
        @RequestBody EmployeeRequest employee
    ){
        return ResponseEntity.ok(this.employeeService.update(employee, id));
    }




    
}
