package com.automation.training.util.env;


import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

/**
 * Yaml files
 */
public class ReadConfigFile {

    private static final Logger LOGGER = LogManager.getLogger(ReadConfigFile.class.getName());
    private static final String PATH_CONFIG = "src/test/resources/config/%s";
    private final String configFile;
    private Map<String, Object> properties;

    public ReadConfigFile(String configFile) {
        this.configFile = configFile;

    }

    public static ReadConfigFile getInstance(String configFile) {
        return new ReadConfigFile(configFile);
    }

    public void uploadProperties() {
        String path = String.format(PATH_CONFIG,configFile);
        YamlReader yamlReader = null;
        try {
           yamlReader = new YamlReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            this.properties = (Map<String, Object>) yamlReader.read();
        } catch (YamlException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public Object getProperty(Object value) {
        return  properties.get(value);
    }
}
