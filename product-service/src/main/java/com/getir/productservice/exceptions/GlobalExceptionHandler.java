package com.getir.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles custom API exceptions with custom message and HTTP status
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponse> handleApiException(ApiException ex) {
        return new ResponseEntity<>(new ExceptionResponse(
                ex.getMessage(),
                ex.getHttpStatus().value(),
                LocalDateTime.now()), ex.getHttpStatus());
    }

    // Handles validation errors for @Valid annotated request bodies
    // Example: missing required fields or invalid values
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Handles invalid JSON format in request bodies
    // Example: sending malformed JSON or wrong data types
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleJsonParseException(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ExceptionResponse(
                "Invalid JSON format: " + ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    // Handles any other uncaught exceptions as a fallback
    // Should be kept at the bottom as a catch-all
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(new ExceptionResponse(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handles cases where method arguments (like UUID) fail to convert
    // Example: passing a non-UUID string to a UUID @PathVariable
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(new ExceptionResponse(
                "Invalid UUID format: " + ex.getValue(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
