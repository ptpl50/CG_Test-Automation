package com.cleargear.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PopertyUtils {
	private static Properties prop;

    static {

        prop = new Properties();

        String filePath = System.getProperty("user.dir")
                + "/src/main/java/com/cleargear/config/config.propertiesnew";

        try (FileInputStream fis = new FileInputStream(filePath)) {

            prop.load(fis);

           // System.out.println("Configuration file loaded successfully from: " + filePath);

        }

        catch (IOException e) {

            throw new RuntimeException(
                    "ERROR: Unable to load config.properties file.\n"
                    + "Expected Location: " + filePath + "\n"
                    + "Reason: " + e.getMessage());
        }
    }

    private PopertyUtils() {}

    public static String get(String key) {

        String value = prop.getProperty(key);

        if (value == null || value.trim().isEmpty()) {

            throw new RuntimeException(
                    "ERROR: Property '" + key + "' not found in config.properties file.");
        }

        return value.trim();
    }

}
