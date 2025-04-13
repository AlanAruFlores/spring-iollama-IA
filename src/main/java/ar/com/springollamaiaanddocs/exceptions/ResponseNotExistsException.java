package ar.com.springollamaiaanddocs.exceptions;

public class ResponseNotExistsException extends RuntimeException{
    public ResponseNotExistsException(String message){
        super(message);
    }
}
