package io.mapovent.app.transport.rest;

import com.mongodb.MongoException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Log4j2
public class ControllerAdvice {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity not found")
    @ExceptionHandler({MongoException.class})
    @ResponseBody
    public ResponseEntity handleNotFoundException(Throwable e, WebRequest request) {
        if (e.getMessage() != null && !e.getMessage().isEmpty()) {
            log.error(e.getMessage(), e);
        }
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity handleException(Throwable e, WebRequest request) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
