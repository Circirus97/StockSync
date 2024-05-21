package com.riwi.StockSync.util.message;

public class ErrorMessage {

    public static final String RequiredName = "The name is required";
    public static final String RequiredLocation= "Location is required";
    public static final String MaxCharacters40= "The name must have a maximum of 40 characters";
    public static final String MaxCharacters15= "The identity must have a maximum of 15 characters";
    public static final String RequiredPhone= "The phone is required";
    public static final String RequiredDocumentType = "The document type is required";
    public static final String RequiredDocumentNumber= "The document number is required";
    public static final String RequiredId = "The foreing key is required";
    public static final String RequiredPrice = "The price is required";
    public static final String RequiredSize = "The size is required";
    public static final String RequiredColor = "The color is required";
    public static final String RequiredStock = "The stock is required";
    public static final String RequiredDateTime = "The date is required";



   
    public static String IdNotFound(String entity) {
        

        final String message = "There are no records with entity %s with the supplied id";
        return String.format(message,entity);
    
    }

    
}
