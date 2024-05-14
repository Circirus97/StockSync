package com.riwi.StockSync.infrastructure.abstract_services;

import com.riwi.StockSync.api.dto.request.ItemRequest;
import com.riwi.StockSync.api.dto.response.ItemResponseCompleteInformation;

public interface IItemService extends CrudServices<ItemRequest, ItemResponseCompleteInformation, String> {
    
}
