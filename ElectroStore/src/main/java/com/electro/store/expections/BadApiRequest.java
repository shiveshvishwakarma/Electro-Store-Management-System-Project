package com.electro.store.expections;

public class BadApiRequest extends RuntimeException{

    public BadApiRequest(String message){
        super(message);
    }
    public BadApiRequest(){
        super("Bad Request !!");
    }
}
