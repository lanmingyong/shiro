package org.lan.exception;

public class NullFileException extends RuntimeException {
    public NullFileException(){
        super();
    }
    public NullFileException(String message){
        super(message);
    }
}
