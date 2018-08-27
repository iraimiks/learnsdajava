package com.sda.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyReader {
    private final static Logger LOGGER = Logger.getLogger(PropertyReader.class.getName());

    public static void loadPropertyValues() {
        Properties properties = new Properties();
        String villainPropertyFile = "villain.properties";
        String superHeroPropertyFile = "hero.properties";

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(villainPropertyFile);
        InputStream stream2 = loader.getResourceAsStream(superHeroPropertyFile);

        try {
            properties.load(stream);
            properties.load(stream2);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "There were problems loading property file.", e);
        }

        System.setProperties(properties);
    }
}
