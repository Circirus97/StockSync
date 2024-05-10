package com.riwi.StockSync.infrastructure.services;

import com.riwi.StockSync.api.dto.request.InvoiceRequest;
import com.riwi.StockSync.api.dto.response.*;
import com.riwi.StockSync.domain.entities.*;
import com.riwi.StockSync.domain.repositories.*;
import com.riwi.StockSync.infrastructure.services.interfaces.IInvoiceService;
import com.riwi.StockSync.util.exceptions.IdNotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService implements IInvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final EmployeeRepository employeeRepository;
    private final StoreRepository storeRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;


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

        Employee employee = this.employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(()-> new IdNotFoundExeption("employee"));

        Clients client = this.clientRepository.findById(request.getClientId())
                .orElseThrow(()-> new IdNotFoundExeption("client"));

        List<Item> itemList = request.getItemList().stream()
                .map(itemRequest ->  this.productRepository.findById(itemRequest.getProduct_id())
                        .map(product -> Item.builder()
                                .product(product)
                                .quantity(itemRequest.getQuantity())
                                .build())
                        .orElseThrow(()-> new IdNotFoundExeption("product")))
                .toList();

        Invoice invoice = this.requestToInvoice(request, new Invoice());

        invoice.setStore(store);
        invoice.setEmployee(employee);
        invoice.setClient(client);
        invoice.setItemList(itemList);

        return this.entityToResponse(this.invoiceRepository.save(invoice));
    }

    @Override
    public InvoiceCompleteInfoResponse update(InvoiceRequest request, String id) {

        Invoice invoice = this.find(id);

        invoice = this.requestToInvoice(request, invoice);

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
                .id(invoice.getId())
                .store(StoreToInvoiceResponse.builder()
                        .name(invoice.getStore().getName())
                        .location(invoice.getStore().getLocation())
                        .build())
                .client(InvoiceToClientResponse.builder()
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
