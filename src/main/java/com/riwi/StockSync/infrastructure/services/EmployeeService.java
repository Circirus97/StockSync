package com.riwi.StockSync.infrastructure.services;


import com.riwi.StockSync.api.dto.request.EmployeeRequest;
import com.riwi.StockSync.api.dto.response.EmployeeResponse;
import com.riwi.StockSync.api.dto.response.StoreToEmployeeResponse;
import com.riwi.StockSync.domain.entities.Employee;
import com.riwi.StockSync.domain.entities.Store;
import com.riwi.StockSync.domain.repositories.EmployeeRepository;
import com.riwi.StockSync.domain.repositories.StoreRepository;
import com.riwi.StockSync.infrastructure.services.interfaces.IEmployeeService;
import com.riwi.StockSync.util.exceptions.IdNotFoundExeption;
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
    public Page<EmployeeResponse> getAll(int page, int size) {
        if(page<0)
        page = 0;
       PageRequest pagination = PageRequest.of(page, size);
       
       return this.employeeRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public EmployeeResponse create(EmployeeRequest request) {
        /*convertimos la compañia que corresponde con el id que esta dentro del request */
        Store store = this.storeRepository.findById(request.getStoreId()).orElseThrow(()-> new IdNotFoundExeption("store"));

        /*Guardamos en la DB y convertimos la nueva entidad al Dto de respuesta */
        Employee employee = this.requestToEmployee(request, new Employee());
        employee.setStore(store);

        return this.entityToResponse(this.employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponse update(EmployeeRequest request, String id) {
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
    public EmployeeResponse getById(String id) {
        Employee employee = this.find(id);
        return this.entityToResponse(employee);
    }


    private EmployeeResponse entityToResponse(Employee entity){
        EmployeeResponse response = new EmployeeResponse();

        BeanUtils.copyProperties(entity, response);

        StoreToEmployeeResponse storyDto = new StoreToEmployeeResponse();

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
        return this.employeeRepository.findById(id).orElseThrow(()-> new IdNotFoundExeption("employee"));
    }

    private Employee requestToEntity(EmployeeRequest entity, Employee employee){
        employee.setName(entity.getName());
        employee.setIdentity(entity.getIdentity());
        employee.setContact(entity.getContact());
        
        return employee;

    }
    
}
