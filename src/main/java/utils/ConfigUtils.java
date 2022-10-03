package utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        properties = PropertyUtils.loadProp("src/main/java/resources/data.properties");
    }

    public static ConfigUtils getInstance () {
        if(configUtils==null) {
            configUtils=new ConfigUtils();
        }
        return configUtils ;
    }

    public String LoginPageURL() {
        String property= properties.getProperty("LoginPageURL");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't  find the URL ") ;
    }

    public String userId () {
        String property= properties.getProperty("userId");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find the ID ") ;
    }


    public String password () {
        String property= properties.getProperty("password");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any passwords ") ;
    }
}
