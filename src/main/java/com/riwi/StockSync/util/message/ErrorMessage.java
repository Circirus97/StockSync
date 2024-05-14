package com.riwi.StockSync.util.message;

public class ErrorMessage {

    public static final String RequiredName = "The name is required";
    public static String IdNotFound(String entity) {
        

        final String message = "There are no records with entity %s with the supplied id";
        return String.format(message,entity);
    
    }

    
}
