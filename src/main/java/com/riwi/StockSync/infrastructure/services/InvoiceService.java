package com.riwi.StockSync.infrastructure.services;

import com.riwi.StockSync.api.dto.request.InvoiceRequest;
import com.riwi.StockSync.api.dto.response.*;
import com.riwi.StockSync.domain.entities.Invoice;
import com.riwi.StockSync.domain.entities.Store;
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
import java.util.List;
import java.util.stream.Collectors;

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
        Store store = this.storeRepository.findById(request.getStoreId())
                .orElseThrow(()-> new IdNotFoundExeption("Store"));

        Invoice invoice = this.requestToInvoice(request, new Invoice());

        invoice.setStore(store);

        return this.entityToResponse(this.invoiceRepository.save(invoice));
    }

    @Override
    public InvoiceCompleteInfoResponse update(InvoiceRequest request, String id) {
        Invoice invoice = this.find(id);

        Store store = this.storeRepository.findById(request.getStoreId())
                .orElseThrow(()-> new IdNotFoundExeption("Store"));

        invoice = this.requestToInvoice(request, invoice);

        invoice.setStore(store);

        return this.entityToResponse(this.invoiceRepository.save(invoice));

    }

    @Override
    public void delete(String id) {
        Invoice invoice = this.find(id);

        this.invoiceRepository.delete(invoice);
    }

    @Override
    public InvoiceCompleteInfoResponse getById(String id) {
        Invoice invoice = this.find(id);
        return entityToResponse(invoice);
    }

    private InvoiceCompleteInfoResponse entityToResponse(Invoice invoice) {
        return  InvoiceCompleteInfoResponse.builder()
                .store(StoreResponse.builder()
                        .name(invoice.getStore().getName())
                        .location(invoice.getStore().getLocation())
                        .build())
                .client(ClientResponse.builder()
                        .name(invoice.getClient().getName())
                        .documentType(invoice.getClient().getDocumentType())
                        
                        .email(invoice.getClient().getEmail())
                        .phone(String.valueOf(invoice.getClient().getPhoneNumber()))
                        .build())
                .employee(EmployeeResponse.builder()
                        .id(invoice.getEmployee().getId())
                        .name(invoice.getEmployee().getName())
                        .build())
                .itemList(invoice.getItemList()
                        .stream()
                        .map(item -> ItemResponse.builder()
                                .quantity(item.getQuantity())
                                .productResponse(ProductResponse.builder()
                                        .name(item.getProduct().getName())
                                        .price(item.getProduct().getPrice())
                                        .size(item.getProduct().getSize())
                                        .color(item.getProduct().getColor())
                                        .build())
                                .build())
                        .toList())
                .date(invoice.getDate())
                .totalPurchases(invoice.getTotalPurchases())
                .build();
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
