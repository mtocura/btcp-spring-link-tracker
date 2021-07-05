package br.com.aula4.tm.linktracker.exception;

import br.com.aula4.tm.linktracker.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidLinkExceptionHandler {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<?> invalidLinkExceptionHandler(InvalidLinkException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

}
