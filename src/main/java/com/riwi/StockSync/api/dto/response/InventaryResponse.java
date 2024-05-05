package com.riwi.StockSync.api.dto.response;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventaryResponse {
    
    private String id;
    private LocalDate date;
    
}
