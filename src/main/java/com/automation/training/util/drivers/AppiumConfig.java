package com.automation.training.util.drivers;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:connection.properties"})
public interface AppiumConfig extends Config {

    @Key("appium.platform")
    @DefaultValue("Android")
    String platformName();

    @Key("appium.host")
    @DefaultValue("127.0.0.1")
    String host();

    @Key("appium.port")
    @DefaultValue("4723")
    String port();

}
