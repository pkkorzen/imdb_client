package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private static String propertiesFile;

    public static void setPropertiesFile(String propertiesFile) {
        PropertiesLoader.propertiesFile = propertiesFile;
    }

    public static String getProperty(String property) throws IOException {
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(getPath(propertiesFile)));
        return appProps.getProperty(property);
    }

    private static String getPath(String propertiesFile) {
        return Thread.currentThread().getContextClassLoader().getResource(propertiesFile).getPath();
    }

}
