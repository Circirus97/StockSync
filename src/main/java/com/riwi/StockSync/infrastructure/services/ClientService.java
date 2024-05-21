package com.riwi.StockSync.infrastructure.services;

import com.riwi.StockSync.api.dto.request.ClientRequest;
import com.riwi.StockSync.api.dto.response.ClientToInvoiceResponse;
import com.riwi.StockSync.api.dto.response.InvoiceResponse;
import com.riwi.StockSync.domain.entities.Clients;
import com.riwi.StockSync.domain.entities.Invoice;
import com.riwi.StockSync.domain.repositories.ClientRepository;
import com.riwi.StockSync.infrastructure.abstract_services.IClientService;
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

        Clients clients = this.requestToEntity(request,new Clients());

        return this.entityToResponse(this.clientRepository.save(clients));
    }

    @Override
    public ClientToInvoiceResponse update(ClientRequest request, String id) {
        Clients clientToChange = this.find(id);
        
        Clients client = this.requestToEntity(request, clientToChange);
        
        return this.entityToResponse(this.clientRepository.save(client));

    }

    @Override
    public void delete(String id) {
        Clients clients = this.find(id);
        this.clientRepository.delete(clients);
    }

    @Override
    public ClientToInvoiceResponse getById(String id) {
        Clients client = this.find(id);
        return this.entityToResponse(client);
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

    private Clients requestToEntity(ClientRequest request, Clients clients){

        BeanUtils.copyProperties(request, clients);
        clients.setInvoices(new ArrayList<>());
        return clients;
    }

    private Clients find(String id){
        return this.clientRepository.findById(id).orElseThrow(()-> new BadRequestExeption("client"));
    }

    public ClientToInvoiceResponse getInvoiceByDocument(int documentNumber) {

        Clients client = clientRepository.findByDocumentNumber(documentNumber)
                .orElseThrow(() -> new BadRequestExeption("Client not found"));

        return entityToResponse(client);
    }

}
