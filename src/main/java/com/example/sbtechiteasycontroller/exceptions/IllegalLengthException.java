package com.example.sbtechiteasycontroller.exceptions;

public class IllegalLengthException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public IllegalLengthException() {
        super();
    }
    public IllegalLengthException(String message) {
        super(message);
    }
}
