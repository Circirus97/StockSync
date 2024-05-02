package com.riwi.StockSync.util.exceptions;

public class IdNotFoundExeption extends RuntimeException {
    private static final String ERROR_MESGE ="There are no records in the entity %s with the supplied id";

    public IdNotFoundExeption(String nameEntity){
     super(String.format(ERROR_MESGE, nameEntity));
 
    } 
}
