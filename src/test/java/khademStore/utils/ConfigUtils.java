package khademStore.utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;
    private ConfigUtils(){
        String environment = System.getProperty("environment","local");
        switch (environment){
            case "local":
                properties=new PropertiesUtils().propertiesLoad("src\\test\\java\\khademStore\\config\\azka.properties");
                break;
            case"ip":
                properties=new PropertiesUtils().propertiesLoad("src\\test\\java\\khademStore\\config\\azka_ip.properties");
                break;
            default:
                throw new RuntimeException("the env doesn't exist");
        }
    }
    public static ConfigUtils getInstance(){
        if (configUtils==null){
            configUtils= new ConfigUtils();
        }
        return configUtils;

    }
    public String getUrl(){
            String property = properties.getProperty("baseUrl");
            if (property!=null){
            return property;}
        throw new RuntimeException("base Url doesn't exist");
    }

    public String getItemsPageUrl(){
        String property=properties.getProperty("itemsPage");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("itemsPageUrl doesn't exist");
    }
    public String getItemReceivedRecordPage(){
        String property=properties.getProperty("itemReceivedRecord");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("itemReceivedRecord doesn't exist");
    }

    public String getStoreCurator(){
        String property = properties.getProperty("storeCurator");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Reports Page doesn't exist");

    }
    public String getReportsPage(){
        String property=properties.getProperty("reports");
        if (property!=null){
            return property;
        }
        throw new RuntimeException("Reports Page doesn't exist");

    }






}
