package me.dio.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException businessException) {
        return new ResponseEntity<>("Resource Id not found.", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleThrowable(Throwable unexpectedExceptionn) {
        var message = "Unexpected server error, see the logs for more details.";
        logger.error(message, unexpectedExceptionn);
        return new ResponseEntity<>("Unexpected server error.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
