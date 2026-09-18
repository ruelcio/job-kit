package ao.JobKit.jobkit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String>   handleEmailAldearyExists(
        EmailAlreadyExistsException exception) {
            return (ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage()));
        }
}
