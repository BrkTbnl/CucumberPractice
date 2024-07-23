package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getPropertyObject() throws IOException {
        FileInputStream fp = new FileInputStream("Config/config.properties");
        Properties properties = new Properties();
        properties.load(fp);
        return properties;

    }

    public static String getDbUrl() throws IOException {

        return getPropertyObject().getProperty("DbUrl");
    }

    public static String getUsername() throws IOException {

        return getPropertyObject().getProperty("username");
    }

    public static String getPassword() throws IOException {
        return getPropertyObject().getProperty("password");
    }

}
