package com.demo.taskmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoContentFoundException extends RuntimeException {

    public NoContentFoundException(final String message) {
        super(message);
    }
}
