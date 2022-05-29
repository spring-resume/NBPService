package pl.edu.pjwstk.nbpservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handleNotFoundException() {
        return ResponseEntity.status(404).body("Nie znaleziono zasobu");
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<String> handleInvalidDataOrLimitExceededException() {
        return ResponseEntity.status(400).body("Nieprawidłowe dane / Przekoczono limit 367 dni");
    }

}
