package com.electro.store.expections;

import lombok.Builder;

@Builder
public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(){
        super("Resource not found !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
