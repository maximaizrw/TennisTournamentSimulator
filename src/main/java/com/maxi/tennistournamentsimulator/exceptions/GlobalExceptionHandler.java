package com.maxi.tennistournamentsimulator.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidFormatException(InvalidFormatException ex) {
        String fieldName = ex.getPath().get(0).getFieldName(); // Obtiene el campo con el error
        String invalidValue = ex.getValue().toString(); // Obtiene el valor enviado
        String message = "El campo '" + fieldName + "' tiene un valor inválido: '" + invalidValue + "'.";
        String path = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getRequestURI();


        Map<String, Object> body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Bad Request",
                "message", message,
                "path", path
        );

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Bad Request");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("path", "/api/v1/tournaments"); // Podrías capturarlo dinámicamente si lo necesitas

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
