package com.riwi.StockSync.infrastructure.abstract_services;

import com.riwi.StockSync.api.dto.request.ClientRequest;
import com.riwi.StockSync.api.dto.response.ClientToInvoiceResponse;

public interface IClientService extends CrudServices<ClientRequest, ClientToInvoiceResponse, String> {
    
}
