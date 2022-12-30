package com.automation.training.tests;

import com.automation.training.BaseMobileTest;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

public class NavigationTest extends BaseMobileTest {

    /**
     * Validate Map Screen Navigation.
     */
    @Description(value = "Map screen Navigation test")
    @Test()
    public void navigateToMapScreen() {
        log.info("Start Navigation to Map Screen");

    }

}
