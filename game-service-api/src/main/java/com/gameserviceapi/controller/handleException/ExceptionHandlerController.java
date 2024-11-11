package com.gameserviceapi.controller.handleException;

import com.gameserviceapi.commons.dto.ErrorResponse;
import com.gameserviceapi.commons.exceptions.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(value = {GameException.class})
    ResponseEntity<ErrorResponse> handleError(GameException gameException) {
        log.error("New Exception", gameException);
        var errorResponse = ErrorResponse.builder()
                .statusCode(gameException.getHttpStatus().value())
                .message(gameException.getMessage())
                .build();
        return ResponseEntity.status(gameException.getHttpStatus()).body(errorResponse);
    }
}
