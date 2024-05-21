package com.riwi.StockSync.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudServices <RQ, RS, ID> {

    Page<RS> getAll(int page, int size);
    //cuando no le ponemos nada a los metodos se entiende que lleva adelante public
    RS create(RQ request);

    RS update(RQ request, ID id);

    void delete(ID id);

    RS getById(ID id);

    
}
