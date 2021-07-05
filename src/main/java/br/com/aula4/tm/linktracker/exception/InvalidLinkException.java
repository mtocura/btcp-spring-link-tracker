package br.com.aula4.tm.linktracker.exception;

public class InvalidLinkException extends RuntimeException{

    public InvalidLinkException(String message) {
        super(message);
    }

    public InvalidLinkException(Exception e) {
        super(e);
    }
}
