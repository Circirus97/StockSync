package com.riwi.StockSync.infrastructure.services;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.StockSync.api.dto.request.ClientRequest;
import com.riwi.StockSync.api.dto.response.ClientToInvoiceResponse;
import com.riwi.StockSync.api.dto.response.InvoiceResponse;
import com.riwi.StockSync.domain.entities.Clients;
import com.riwi.StockSync.domain.entities.Invoice;
import com.riwi.StockSync.domain.repositories.ClientRepository;
import com.riwi.StockSync.infrastructure.services.interfaces.IClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {
    
    @Autowired
    private final ClientRepository clientRepository;

    @Override
    public Page<ClientToInvoiceResponse> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);

        
        return this.clientRepository.findAll(pagination).map(this::entityToResponse) ;

        
    }

    @Override
    public ClientToInvoiceResponse create(ClientRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ClientToInvoiceResponse update(ClientRequest request, String id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ClientToInvoiceResponse getById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    
    private ClientToInvoiceResponse entityToResponse(Clients client){
        ClientToInvoiceResponse response = new ClientToInvoiceResponse();
        
        BeanUtils.copyProperties(client, response);
        
        response.setInvoices(client.getInvoices().stream().map(this::invoiceToResponse).collect(Collectors.toList()));
        
        return response;
    }
    
    private InvoiceResponse invoiceToResponse(Invoice invoice){
        InvoiceResponse response = new InvoiceResponse();

        BeanUtils.copyProperties(invoice, response);

        return response;
    }
}
