package org.example.ss08.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ss08.models.dtos.wrapper.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidException(HttpServletRequest request, HttpServletResponse response, MethodArgumentNotValidException ex) {
        /*
            {
                "name" : "name không được để trống",
                "phone" : "phone không đúng định dạng"
                ...
            }
        */

        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(
                err -> {
                    errors.put(
                            err.getField(),
                            err.getDefaultMessage()

                    );
                }
        );

        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .status("ERROR")
                        .message("Validation Failed")
                        .data(errors)
                        .build()
        );

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ApiResponse.builder()
                    .status("ERROR")
                    .message("Not Found")
                    .data(ex.getMessage())
                    .build()
        );
    }



}
