package com.automation.training.util.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Optional;

public abstract class ConfigCapabilities {

    private Optional<Capabilities> capabilities;
    private final String platform;
    private static final String FILE_SEPARATOR = File.separator;
    public static final String PATH_RESOURCES = String.format("src%stest%sresources%sconfig%s", FILE_SEPARATOR, FILE_SEPARATOR, FILE_SEPARATOR, FILE_SEPARATOR);

    ConfigCapabilities(String platform){
        this.platform = platform;
        this.capabilities = Optional.empty();
    }

    public DesiredCapabilities uploadCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        String propertiesFileName = PATH_RESOURCES + DriversConfigFile.getFileNameCalled(platform);
        ReadProperties properties = ReadProperties.getInstance(propertiesFileName);
        properties.getProperties().entrySet().iterator().forEachRemaining(entry -> {
                    String property = entry.getKey().toString();
                    String value = entry.getValue().toString();
                    desiredCapabilities.setCapability(property, value);
                }
                );
        if(this.capabilities.isPresent()){
            desiredCapabilities.merge(capabilities.get());
        }
        return desiredCapabilities;
    }


}
