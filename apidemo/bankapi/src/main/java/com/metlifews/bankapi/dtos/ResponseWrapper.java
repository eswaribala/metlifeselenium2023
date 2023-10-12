package com.metlifews.bankapi.dtos;

public class ResponseWrapper<T> {
    private String message;
    private T object;
    public ResponseWrapper(T object){
        this.object=object;

    }
    public ResponseWrapper(String message){
        this.message=message;
    }
}
