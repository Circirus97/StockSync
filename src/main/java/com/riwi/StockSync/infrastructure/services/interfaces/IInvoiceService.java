package com.riwi.StockSync.infrastructure.services.interfaces;


import com.riwi.StockSync.api.dto.request.InvoiceRequest;
import com.riwi.StockSync.api.dto.response.InvoiceCompleteInfoResponse;

public interface IInvoiceService extends CrudServices<InvoiceRequest, InvoiceCompleteInfoResponse, String> {

}
