package com.automation.training.exceptions;

public class FailedUrlConnectionException extends AssertionError {

    public static final String FAILED_URL_CALLING = "Failed url calling: %s";

    public FailedUrlConnectionException(String message) {
        super(message);
    }
}
