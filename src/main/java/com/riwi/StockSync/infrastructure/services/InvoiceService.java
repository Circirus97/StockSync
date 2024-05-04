package com.riwi.StockSync.infrastructure.services;

import com.riwi.StockSync.api.dto.request.InvoiceRequest;
import com.riwi.StockSync.api.dto.response.EmployeeResponse;
import com.riwi.StockSync.api.dto.response.InvoiceCompleteInfoResponse;
import com.riwi.StockSync.api.dto.response.StoreResponse;
import com.riwi.StockSync.domain.entities.Invoice;
import com.riwi.StockSync.domain.repositories.EmployeeRepository;
import com.riwi.StockSync.domain.repositories.InvoiceRepository;
import com.riwi.StockSync.domain.repositories.StoreRepository;
import com.riwi.StockSync.infrastructure.services.interfaces.IInvoiceService;
import com.riwi.StockSync.util.exceptions.IdNotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class InvoiceService implements IInvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final EmployeeRepository employeeRepository;
    private final StoreRepository storeRepository;
/*    private final ClientRepository clientRepository;
    private final ItemRepository ItemRepository;*/

    @Override
    public Page<InvoiceCompleteInfoResponse> getAll(int page, int size) {
        if (page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.invoiceRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public InvoiceCompleteInfoResponse create(InvoiceRequest request) {
        return null;
    }

    @Override
    public InvoiceCompleteInfoResponse update(InvoiceRequest request, String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public InvoiceCompleteInfoResponse getById(String s) {
        return null;
    }

    private InvoiceCompleteInfoResponse entityToResponse(Invoice entity) {
        // Creamos instancia del DTO de factura
        InvoiceCompleteInfoResponse response = new InvoiceCompleteInfoResponse();

        // Copiar todas las propiedades de la entidad en el DTO
        BeanUtils.copyProperties(entity, response);

        // Creamos instancia del DTO de tienda
        StoreResponse storeDTO = new StoreResponse();
        // Copiar todas las propiedades de la tienda que se encuentra dentro de la entidad (Invoice) en el DTO de respuesta
        BeanUtils.copyProperties(entity.getStore(), storeDTO);
        // Agregamos el DTO lleno a la respuesta final
        response.setStore(storeDTO);

        // Creamos instancia del DTO de empleado
        EmployeeResponse employeeDTO = new EmployeeResponse();
        // Copiar todas las propiedades del empleado que se encuentra dentro de la entidad (Invoice) en el DTO de respuesta
        BeanUtils.copyProperties(entity.getEmployee(), employeeDTO);
        // Agregamos el DTO lleno a la respuesta final
        response.setEmployee(employeeDTO);

/*        // Creamos instancia del DTO de cliente
        ClientResponse clientDTO = new ClientResponse();
        // Copiar todas las propiedades del cliente que se encuentra dentro de la entidad (Invoice) en el DTO de respuesta
        BeanUtils.copyProperties(entity.getClient(), clientDTO);
        // Agregamos el DTO lleno a la respuesta final
        response.setClient(clientDTO);*/

/*        // Mapeamos la lista de items de la factura
        List<ItemResponse> itemList = entity.getItemList().stream()
                .map(item -> {
                    ItemResponse itemResponse = new ItemResponse();
                    BeanUtils.copyProperties(item, itemResponse);
                    return itemResponse;
                })
                .collect(Collectors.toList());

        // Asignamos la lista mapeada al DTO de respuesta
        response.setItemList(itemList);*/

        return response;
    }

    private Invoice requestToInvoice(InvoiceRequest request, Invoice entity){

        entity.setDate(request.getDate());
        entity.setTotalPurchases(request.getTotalPurchases());
        entity.setItemList(new ArrayList<>());

        return entity;
    }

    private Invoice find(String id){
        return this.invoiceRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundExeption("Invoice"));
    }

}
