package com.automation.training.util.env;

import com.automation.training.util.drivers.AppiumServer;
import com.browserstack.local.Local;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EnvironmentConfig {

    private Map<String, Object> commonCapabilities;
    private DesiredCapabilities desiredCapabilities;
    private AppiumServer appiumServer;
    public EnvironmentConfig(Map<String, Object> config){
        this.commonCapabilities = config;
    }

    public void setUp() {
        setServerAddress();
        Map<String,Object> capabilitities = (Map<String,Object>)commonCapabilities.get("capabilities");
        if(capabilitities.get("browserstackLocal").toString().equalsIgnoreCase("true")) {
            Local local = new Local();
            try {
                local.start(Collections.singletonMap("key", appiumServer.getPassword()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        configCapabilities();
    }

    private void setServerAddress() {
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String password = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String server =  commonCapabilities.get("server").toString();
        username = username == null? commonCapabilities.get("user").toString() : username;
        password = password == null? commonCapabilities.get("key").toString() : password;
        this.appiumServer = new AppiumServer(username,password,server);
    }

    public void configCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        Map<String,Object> capabilities = (Map<String,Object>) commonCapabilities.get("capabilities");
        capabilities.forEach(desiredCapabilities::setCapability);

        List<Map<String, String>> deviceCapabilities = (List<Map<String, String>>) commonCapabilities.get("platforms");
        deviceCapabilities.stream().flatMap(platform -> platform.entrySet().stream())
                .forEach(cap -> desiredCapabilities.setCapability(cap.getKey(), cap.getValue()));

        String app = System.getenv("BROWSERSTACK_APP_ID");
        if(app != null && !app.isEmpty()) {
            desiredCapabilities.setCapability("app", app);
        }
        this.desiredCapabilities = desiredCapabilities;
    }

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public AppiumServer getAppiumServer() {
        appiumServer.createUrlAddress();
        return appiumServer;
    }
    
    
}
