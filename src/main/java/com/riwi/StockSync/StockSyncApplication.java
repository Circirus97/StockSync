package com.riwi.StockSync;

import com.riwi.StockSync.infrastructure.helpers.EmailHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockSyncApplication.class, args);
	}

}
