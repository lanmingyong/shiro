package org.lan.exception;

public class ExtException extends RuntimeException {
    public ExtException(){
        super();
    }
    public ExtException(String message){
        super(message);
    }
}
