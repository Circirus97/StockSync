package com.riwi.StockSync.util.message;

public class ErrorMessage {

    public static final String RequiredName = "The name is required";
    public static final String RequiredLocation= "Location is required";
    public static final String MaxCharacters40= "The name must have a maximum of 40 characters";
    public static final String MaxCharacters15= "The identity must have a maximum of 15 characters";
    public static final String RequiredPhone= "The phone is required";
    public static final String RequiredDocumentType = "The document type is required";
    public static final String RequiredDocumentNumeber= "The document number is required";
   
    public static String IdNotFound(String entity) {
        

        final String message = "There are no records with entity %s with the supplied id";
        return String.format(message,entity);
    
    }

    
}
