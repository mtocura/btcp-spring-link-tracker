package br.com.aula4.tm.linktracker.exception;

import br.com.aula4.tm.linktracker.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkExceptionHandler {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<?> invalidLinkExceptionHandler(InvalidLinkException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(e.getMessage()));
    }


    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<?> missingHeaderHandler(MissingRequestHeaderException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO("Header param token not found"));
    }
}
