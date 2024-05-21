package com.riwi.StockSync.infrastructure.helpers;

import com.riwi.StockSync.domain.entities.Item;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmailHelper {

    //Inyección servicio de email de la librería
    private final JavaMailSender mailSender;

    //Método para mandar el email
    public void sendMail(String idInvoice, String store, String destinity, String nameClient, String nameEmployee, LocalDate date, List<Item> itemList, Double totalPurchases){

        MimeMessage message = mailSender.createMimeMessage();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String dateInvoice = date.format(formatter);
        String htmlContent = this.readHTMLTemplate(idInvoice, store, nameClient, dateInvoice, nameEmployee, itemList, totalPurchases);

        try{
            message.setFrom(new InternetAddress("stocksync2024@gmail.com"));
            message.setSubject("Factura");

            message.setRecipients(MimeMessage.RecipientType.TO, destinity);
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);

            mailSender.send(message);
            System.out.println("Email enviado");
        }catch (Exception e){
            System.out.println("ERROR no se pudo enviar el email" + e.getMessage());
        }
    }



    //Método para leer el html
    private String readHTMLTemplate(String idInvoice, String store, String nameClient, String date, String nameEmployee, List<Item> itemList, Double totalPurchases){
        //Se indica ubicación del template
        final Path path = Paths.get("src/main/resources/emails/email_template.html");

        try(var lines = Files.lines(path)){

            var html = lines.collect(Collectors.joining());

            return html.replace("{idInvoice}", idInvoice). replace("{store}", store).replace("{nameClient}", nameClient).replace("{date}", date).replace("{nameEmployee}", nameEmployee).replace("{itemList}", itemList.toString()).replace("{totalPurchases}", String.valueOf(totalPurchases));

        }catch (IOException e){
            System.out.println("The HTML could not be read.");
            throw new RuntimeException();
        }
    }
}