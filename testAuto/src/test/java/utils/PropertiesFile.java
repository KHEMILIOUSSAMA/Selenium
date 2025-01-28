package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesFile {
    private static HashMap<String, String> propertiesMap = new HashMap<>();

    public static HashMap<String, String> read(String propertiesFilePath) {
        File file = new File(propertiesFilePath);
        if (!file.exists()) {
            System.err.println("Fichier de propriétés introuvable : " + propertiesFilePath);
            return null;
        }

        Properties properties = new Properties();
        try (FileInputStream fileInput = new FileInputStream(file)) {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Remplissage de la map
        propertiesMap.clear();
        Enumeration<?> keys = properties.propertyNames();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = properties.getProperty(key);
            propertiesMap.put(key, value);
        }

        return propertiesMap;
    }
}

