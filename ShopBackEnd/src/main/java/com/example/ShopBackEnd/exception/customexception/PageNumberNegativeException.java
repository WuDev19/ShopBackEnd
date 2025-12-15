package com.example.ShopBackEnd.exception.customexception;

public class PageNumberNegativeException extends RuntimeException{

    public PageNumberNegativeException(String message){
        super(message);
    }

}
