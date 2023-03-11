package com.automation.training.util.drivers;

import com.automation.training.exceptions.NotFoundFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private static final Logger LOGGER = LogManager.getLogger(ReadProperties.class.getName());
    private String path;

    private ReadProperties(String path) {
        this.path = path;
    }

    public static ReadProperties getInstance(String path){
        return new ReadProperties(path);
    }

    public Properties getProperties(){
        Properties properties = new Properties();
        File file = new File(path);
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new NotFoundFileException(e);
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                   LOGGER.error(e);
                }
            }
        }
        return properties;
    }


}
