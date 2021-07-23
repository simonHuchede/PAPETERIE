package fr.eni.papeterie.dal;

import java.util.Properties;

public class Settings {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(Settings.class.getResourceAsStream("jdbc.properties"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key, null);
    }
}