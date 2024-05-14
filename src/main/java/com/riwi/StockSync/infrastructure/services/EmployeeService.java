package com.riwi.StockSync.infrastructure.services;


import com.riwi.StockSync.api.dto.request.EmployeeRequest;
import com.riwi.StockSync.api.dto.response.EmployeeToStoreResponse;
import com.riwi.StockSync.api.dto.response.StoreResponse;
import com.riwi.StockSync.domain.entities.Employee;
import com.riwi.StockSync.domain.entities.Store;
import com.riwi.StockSync.domain.repositories.EmployeeRepository;
import com.riwi.StockSync.domain.repositories.StoreRepository;
import com.riwi.StockSync.infrastructure.services.interfaces.IEmployeeService;
import com.riwi.StockSync.util.exceptions.BadRequestExeption;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {
    
    @Autowired
    private final EmployeeRepository employeeRepository;
    private final StoreRepository storeRepository;
    
    @Override
    public Page<EmployeeToStoreResponse> getAll(int page, int size) {
        if(page<0)
        page = 0;
       PageRequest pagination = PageRequest.of(page, size);
       
       return this.employeeRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public EmployeeToStoreResponse create(EmployeeRequest request) {
        /*convertimos la compañia que corresponde con el id que esta dentro del request */
        Store store = this.storeRepository.findById(request.getStoreId()).orElseThrow(()-> new BadRequestExeption("store"));

        /*Guardamos en la DB y convertimos la nueva entidad al Dto de respuesta */
        Employee employee = this.requestToEmployee(request, new Employee());
        employee.setStore(store);

        return this.entityToResponse(this.employeeRepository.save(employee));
    }

    @Override
    public EmployeeToStoreResponse update(EmployeeRequest request, String id) {
        Employee employeeToUpdate = this.find(id);

        Employee employee =this.requestToEntity(request, employeeToUpdate);
        return this.entityToResponse(this.employeeRepository.save(employee));
    }

    @Override
    public void delete(String id) {
        Employee employee = this.find(id);
       this.employeeRepository.delete(employee);
    }

    @Override
    public EmployeeToStoreResponse getById(String id) {
        Employee employee = this.find(id);
        return this.entityToResponse(employee);
    }


    private EmployeeToStoreResponse entityToResponse(Employee entity){
        EmployeeToStoreResponse response = new EmployeeToStoreResponse();

        BeanUtils.copyProperties(entity, response);

        StoreResponse storyDto = new StoreResponse();

        BeanUtils.copyProperties(entity.getStore(), storyDto);

        response.setStore(storyDto);

        return response;
    }

    private Employee requestToEmployee(EmployeeRequest request, Employee entity){
        entity.setName(request.getName());
        entity.setIdentity(request.getIdentity());
        entity.setContact(request.getContact());
 
        return entity;

    }
    private Employee find(String id){
        return this.employeeRepository.findById(id).orElseThrow(()-> new BadRequestExeption("employee"));
    }

    private Employee requestToEntity(EmployeeRequest entity, Employee employee){
        employee.setName(entity.getName());
        employee.setIdentity(entity.getIdentity());
        employee.setContact(entity.getContact());
        
        return employee;

    }
    
}
