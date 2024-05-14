package com.riwi.StockSync.infrastructure.services;

import com.riwi.StockSync.api.dto.request.StoreRequest;
import com.riwi.StockSync.api.dto.response.EmployeeResponse;
import com.riwi.StockSync.api.dto.response.StoreToEmployeeResponse;
import com.riwi.StockSync.domain.entities.Employee;
import com.riwi.StockSync.domain.entities.Store;
import com.riwi.StockSync.domain.repositories.StoreRepository;
import com.riwi.StockSync.infrastructure.services.interfaces.IStoreService;
import com.riwi.StockSync.util.exceptions.BadRequestExeption;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StoreService implements IStoreService {
    
    @Autowired
    private final StoreRepository storeRepository;

    @Override
    public Page<StoreToEmployeeResponse> getAll(int page, int size) {
        if(page<0)
        page = 0;
       PageRequest pagination = PageRequest.of(page, size);
       
       return this.storeRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public StoreToEmployeeResponse create(StoreRequest request) {
        Store store = this.requestToEntity(request, new Store());
        return this.entityToResponse(this.storeRepository.save(store));
    }

    @Override
    public StoreToEmployeeResponse update(StoreRequest request, String id) {
        Store storeToUpdate = this.find(id);

        Store store =this.requestToEntity(request, storeToUpdate);
        return this.entityToResponse(this.storeRepository.save(store));
    }

    @Override
    public void delete(String id) {
        Store store = this.find(id);
        this.storeRepository.delete(store);
    }

    @Override
    public StoreToEmployeeResponse getById(String id) {
        Store store = this.find(id);
        return this.entityToResponse(store);
    }



    private StoreToEmployeeResponse entityToResponse(Store entity){
        StoreToEmployeeResponse response = new StoreToEmployeeResponse();
        BeanUtils.copyProperties(entity, response);
         response.setEmployees(entity.getEmployee().stream().map(employee-> this.employeeToResponse(employee)).collect(Collectors.toList()));
        return response;
    }

    private EmployeeResponse employeeToResponse(Employee entity){
        EmployeeResponse response = new EmployeeResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

     private Store requestToEntity(StoreRequest entity, Store store){
        store.setName(entity.getName());
        store.setLocation(entity.getLocation());
        store.setEmployee(new ArrayList<>());
        return store;


    }

    private Store find(String id){
        return this.storeRepository.findById(id).orElseThrow(()-> new BadRequestExeption("store"));
    }
    
}
