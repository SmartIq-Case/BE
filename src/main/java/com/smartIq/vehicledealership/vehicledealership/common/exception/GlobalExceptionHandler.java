package com.smartIq.vehicledealership.vehicledealership.common.exception;

import com.smartIq.vehicledealership.vehicledealership.common.authorizationChecker.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity<Void> handleUnauthorizedException(final UnauthorizedException unauthorizedException) {

        log.error(unauthorizedException.getMessage(), unauthorizedException);


        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Void> handleProcessError(final Exception exception) {

        log.error(exception.getMessage(), exception);


        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
