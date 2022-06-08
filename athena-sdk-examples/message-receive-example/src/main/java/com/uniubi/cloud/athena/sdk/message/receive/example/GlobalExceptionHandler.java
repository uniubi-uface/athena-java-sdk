package com.uniubi.cloud.athena.sdk.message.receive.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ExceptionHandler
 *
 * @author jingmu
 * @since 2022/06/08
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handlerException(Exception e) {
        log.info("exception occurred:{}", e.getMessage(), e);
        return e.getMessage();
    }

}
