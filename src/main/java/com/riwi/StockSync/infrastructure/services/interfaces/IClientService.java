package com.riwi.StockSync.infrastructure.services.interfaces;

import com.riwi.StockSync.api.dto.request.ClientRequest;
import com.riwi.StockSync.api.dto.response.ClientToInvoiceResponse;

public interface IClientService extends CrudServices<ClientRequest, ClientToInvoiceResponse, String>{
    
}
