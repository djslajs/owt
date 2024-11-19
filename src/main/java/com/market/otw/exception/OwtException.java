package com.market.otw.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public abstract class OwtException extends RuntimeException{

    public final Map<String, String> validation = new HashMap<>();

    public OwtException(String message) {
        super(message);
    }

    public OwtException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getStatusCode();

    public void addValidation(String fieldName, String message) {
        validation.put(fieldName, message);
    }
}
