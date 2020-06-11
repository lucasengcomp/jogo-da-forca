package core;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties = new Properties();

    //executado na primeira vez que a classe é instanciada
    static {
        try {
            properties.load(Config.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String name) {
        return properties.getProperty(name);
    }
}
