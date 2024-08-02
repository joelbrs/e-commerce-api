package tech.joelf.e_commerce_api.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import tech.joelf.e_commerce_api.exceptions.DatabaseException;
import tech.joelf.e_commerce_api.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseException> handleNotFound(HttpServletRequest request, ResourceNotFoundException ex) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status)
                .body(new ResponseException(Instant.now(), status.value(), ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ResponseException> handleDatabase(HttpServletRequest request,
            ResourceNotFoundException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status)
                .body(new ResponseException(Instant.now(), status.value(), ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseException> handleArgumentNotValid(HttpServletRequest request,
            ResourceNotFoundException ex) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        return ResponseEntity.status(status)
                .body(new ResponseException(Instant.now(), status.value(), ex.getMessage(), request.getRequestURI()));
    }
}
