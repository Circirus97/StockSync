/*package com.riwi.StockSync.infrastructure.helpers;

import com.riwi.StockSync.api.dto.response.*;
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
    private String readHTMLTemplate(InvoiceResponse idInvoice, StoreToInvoiceResponse store, InvoiceToClientResponse nameClient, InvoiceResponse date, EmployeeResponse nameEmployee, InvoiceCompleteInfoResponse itemList, InvoiceResponse totalPurchases){
        //Se indica ubicación del template
        final Path path = Paths.get("src/main/resources/emails/email_template.html");

        try(var lines = Files.lines(path)){

            var html = lines.collect(Collectors.joining());

            return html.replace("{idInvoice}", idInvoice.getId()). replace("{store}", store.getName()).replace("{nameClient}", nameClient.getName()).replace("{date}", date.getDate()).replace("{nameEmployee}", nameEmployee.getName()).replace("{itemList}", itemList.getItemList()).replace("{totalPurchases}", totalPurchases.getTotalPurchases());

        }catch (IOException e){
            System.out.println("The HTML could not be read.");
            throw new RuntimeException();
        }
    }
}
*/