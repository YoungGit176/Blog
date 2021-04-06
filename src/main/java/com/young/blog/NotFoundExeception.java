package com.young.blog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExeception extends RuntimeException{
    public NotFoundExeception() {
    }

    public NotFoundExeception(String message) {
        super(message);
    }

    public NotFoundExeception(String message, Throwable cause) {
        super(message, cause);
    }
}
