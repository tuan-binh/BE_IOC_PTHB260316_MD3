package org.example.demo_ss10.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.example.demo_ss10.models.dtos.wrapper.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param request HttpServletRequest
     * @param e       MethodArgumentNotValidException
     * @apiNote handle valid exception validation
     *
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            HttpServletRequest request,
            MethodArgumentNotValidException e
    ) {
        Map<String, String> errors = new HashMap<>();
        e.getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(
                ErrorResponse.builder()
                        .status(400)
                        .error("Validation Failed")
                        .message(errors)
                        .path(request.getRequestURI())
                        .build()
        );
    }

    /**
     * @param request HttpServletRequest
     * @param e       NoResourceFoundException
     * @apiNote handle not found resource on server
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResourceFoundException(
            HttpServletRequest request,
            NoResourceFoundException e
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorResponse.builder()
                        .status(404)
                        .error("Resource Not Found")
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    /**
     * @param request HttpServletRequest
     * @param e       NoResourceFoundException
     * @apiNote handle data conflict
     */
    @ExceptionHandler(DataConflictException.class)
    public ResponseEntity<?> handleDataConflictException(
            HttpServletRequest request,
            DataConflictException e
    ) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorResponse.builder()
                        .status(409)
                        .error("Data Conflict")
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    /**
     * @param request HttpServletRequest
     * @param e       InternalServerError
     * @apiNote handle error server side
     */
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<?> handleInternalServerError(
            HttpServletRequest request,
            HttpServerErrorException.InternalServerError e
    ) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ErrorResponse.builder()
                        .status(500)
                        .error("Internal Server Error")
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponse.builder()
                        .status(400)
                        .error("Bad Request")
                        .message(e.getMessage())
                        .build()
        );
    }

}
