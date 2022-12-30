package com.automation.training.util.drivers;

import com.automation.training.exceptions.FailedDriverCreationException;

public interface DriverBase<T> {

    T createDriver() throws FailedDriverCreationException;
    void loadCapabilities();

}
