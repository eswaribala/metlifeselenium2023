package com.metlife.exceptions;

public class FirstNameNotMatchingException extends RuntimeException{
    public FirstNameNotMatchingException(String message) {
        super(message);
    }
}
