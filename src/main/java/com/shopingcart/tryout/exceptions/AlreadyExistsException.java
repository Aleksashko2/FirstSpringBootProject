package com.shopingcart.tryout.exceptions;

import com.shopingcart.tryout.model.Category;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message){
        super(message);
    }
}
