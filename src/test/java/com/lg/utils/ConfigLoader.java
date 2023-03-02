package com.lg.utils;

import com.lg.constants.Environment;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        String env = System.getProperty("env", Environment.DEV.env);

        switch (env) {
            case "dev" -> {
                properties = PropertyUtils.getProperties("src/test/resources/dev_config.properties");
            }
            case "qa" -> {
                properties = PropertyUtils.getProperties("src/test/resources/qa_config.properties");
            }
            case "prod" -> {
                properties = PropertyUtils.getProperties("src/test/resources/prod_config.properties");
            }
            default -> throw new IllegalStateException("INVALID ENVIRONMENT: " + env);
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        else throw new RuntimeException("Property baseUrl not found");
    }
}
