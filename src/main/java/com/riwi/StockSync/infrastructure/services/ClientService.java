package com.riwi.StockSync.infrastructure.services;

// import java.util.stream.Collector;
// import java.util.stream.Collectors;

// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.StockSync.api.dto.request.ClientRequest;
// import com.riwi.StockSync.api.dto.response.ClientResponse;
import com.riwi.StockSync.api.dto.response.ClientToInvoiceResponse;
// import com.riwi.StockSync.api.dto.response.EmployeeResponse;
// import com.riwi.StockSync.api.dto.response.InvoiceCompleteInfoResponse;
// import com.riwi.StockSync.api.dto.response.InvoiceResponse;
// import com.riwi.StockSync.api.dto.response.StoreResponse;
// import com.riwi.StockSync.domain.entities.Clients;
// import com.riwi.StockSync.domain.entities.Invoice;
// import com.riwi.StockSync.domain.repositories.ClientRepository;
import com.riwi.StockSync.infrastructure.services.interfaces.IClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {
    
    // @Autowired
    // private final ClientRepository clientRepository;

    @Override
    public Page<ClientToInvoiceResponse> getAll(int page, int size) {
        // if (page < 0) {
        //     page = 0;
        // }

        // PageRequest pagination = PageRequest.of(page, size);

        // return this.clientRepository.findAll(pagination).map(this::entityToResponse);
        throw new UnsupportedOperationException("Unimplemented method 'create'");

    }

    @Override
    public ClientToInvoiceResponse create(ClientRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ClientToInvoiceResponse update(ClientRequest request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ClientToInvoiceResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    
    // private ClientToInvoiceResponse entityToResponse(Clients clients){
    //     ClientToInvoiceResponse response = new ClientToInvoiceResponse();
        
    //     BeanUtils.copyProperties(clients, response);
        
    //     response.setInvoices(clients.getInvoices().stream().map(this::invoiceToResponse).collect(Collectors.toList()));
        
    //     return response;
    // }
    
    // private InvoiceResponse invoiceToResponse(Invoice invoice){
    //     InvoiceResponse response = new InvoiceResponse();

    //     BeanUtils.copyProperties(invoice, response);

    //     return response;
    // }
}
