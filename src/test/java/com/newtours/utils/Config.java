package com.newtours.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final Logger log = LoggerFactory.getLogger(ResourceLoader.class);
    private static final String DEFAULT_PROPERTIES = "config/qa.properties";
    private static Properties properties;

    public static void init() {
        properties = loadProperties();
        for (String key : properties.stringPropertyNames()) {
            if (System.getProperties().containsKey(key)) {
                properties.setProperty(key, System.getProperty(key));
            }
        }

        log.info("Test Properties");
        log.info("----------------------------");
        for (String key : properties.stringPropertyNames()) {
            log.info("{}={}", key, properties.getProperty(key));
        }
        log.info("----------------------------");
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
            properties.load(stream);
        } catch (IOException e) {
            log.error("Unable to read resource {}", DEFAULT_PROPERTIES, e);
        }
        return properties;
    }
}
