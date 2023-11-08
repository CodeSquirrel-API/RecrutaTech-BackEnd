package br.gov.sp.fatec.recrutatech.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
    
}
