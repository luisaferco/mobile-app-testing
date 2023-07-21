package com.automation.training.util.drivers;

import com.automation.training.util.drivers.enums.CapabilitiesFile;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Map;
import java.util.Optional;

/**
 * ConfigCapabilities class to get desired capabilities to create
 * a new Appium driver session
 */
public abstract class ConfigCapabilities {

    private final Optional<Capabilities> capabilities;
    private static final String APP = "app";
    private static final String FILE_SEPARATOR = File.separator;
    private static final String PATH_RESOURCES = String.format("src%stest%sresources%sconfig%s", FILE_SEPARATOR, FILE_SEPARATOR, FILE_SEPARATOR, FILE_SEPARATOR);

    ConfigCapabilities(){
        this.capabilities = Optional.empty();
    }

    public DesiredCapabilities uploadCapabilities(String platform) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        String propertiesFileName = PATH_RESOURCES + CapabilitiesFile.getFileNameCalled(platform);
        ReadProperties properties = ReadProperties.getInstance(propertiesFileName);
        properties.getProperties().entrySet().iterator().forEachRemaining(entry -> {
            String property = entry.getKey().toString();
            String value = entry.getValue().toString();
            desiredCapabilities.setCapability(property, value);
            if(isAppRouteContained(entry)){
                property = entry.getKey().toString();
                value = System.getProperty("user.dir").concat(entry.getValue().toString());
                desiredCapabilities.setCapability(property, value);
                }

            }
        );
        if(this.capabilities.isPresent()){
            desiredCapabilities.merge(capabilities.get());
        }
        return desiredCapabilities;
    }

    private boolean isAppRouteContained(Map.Entry<Object, Object> entry) {
        return entry.getKey().toString().equals(APP);
    }


}
