package com.automation.training.exceptions;

public class NotFoundValueException extends AssertionError {

    public NotFoundValueException(String message) {
        super(message);
    }
}
