/*package com.riwi.StockSync.infrastructure.helpers;

import com.riwi.StockSync.api.dto.response.EmployeeResponse;
import com.riwi.StockSync.api.dto.response.InvoiceToClientResponse;
import com.riwi.StockSync.api.dto.response.ItemResponse;
import com.riwi.StockSync.api.dto.response.StoreToInvoiceResponse;
import com.riwi.StockSync.domain.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmailHelper {

    //Inyección servicio de email de la librería
    private final JavaMailSender mailSender;

    //Método para leer el html
    private String readHTMLTemplate(String idInvoice, LocalDate date, Double totalPurchases, StoreToInvoiceResponse store, EmployeeResponse.name nameEmployee, InvoiceToClientResponse client, List<ItemResponse> itemList){
        //Se indica ubicación del template
        final Path path = Paths.get("src/main/resources/emails/email_template.html");

        try(var lines = Files.lines(path)){

            var html = lines.collect(Collectors.joining());

            return html.replace("{idInvoice}", idInvoice).replace("{nameEmployee}", nameEmployee).replace("{date}", date).replace("{totalPurchases}", totalPurchases). replace("{store}", store).replace("{client}", nameClient).replace("{itemList}", itemList);

        }catch (IOException e){
            System.out.println("The HTML could not be read.");
            throw new RuntimeException();
        }
    }
}
*/