package hu.unideb.inf.filmajanlo.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(
            MethodArgumentNotValidException ex){
        Map<String, List<String>> errors = new LinkedHashMap<>();
        ex.getBindingResult().getAllErrors().forEach(err -> {
            String field = (err instanceof FieldError fe)
                    ? fe.getField()
                    : err.getObjectName();

            errors.computeIfAbsent(field,
                    (k) -> new ArrayList<>()).add(err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(Map.of(
                "title", "constraint violation",
                "status", "400",
                "errors", errors,
                "timestamp", System.currentTimeMillis()
        ));

    }
}
