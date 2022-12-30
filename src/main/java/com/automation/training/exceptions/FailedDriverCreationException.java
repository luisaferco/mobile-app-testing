package com.automation.training.exceptions;

public class FailedDriverCreationException extends AssertionError {

    public static final String FAILED_DRIVER_CREATION = "Failed driver creation ";
    public static final Throwable NULL_DRIVER = new Throwable("driver is null");

    public FailedDriverCreationException(String message) {
        super(message);
    }
}
