package com.riwi.StockSync.infrastructure.services.interfaces;

import com.riwi.StockSync.api.dto.request.ItemRequest;
import com.riwi.StockSync.api.dto.response.ItemResponse;
import com.riwi.StockSync.api.dto.response.ItemResponseCompleteInformation;

public interface IItemService extends CrudServices<ItemRequest, ItemResponseCompleteInformation, String>{
    
}
