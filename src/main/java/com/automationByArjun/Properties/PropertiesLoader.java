package com.automationByArjun.Properties;


import com.automationByArjun.ConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {

    static Properties configProperties;

    public static String runOnBrowser;
    public static Boolean takeScreenshot;
    public static String chromeDriverPath;
    public static String ieDriverPath;
    public static String edgeDriverPath;
    public static String fireFoxDriverPath;
    public static Boolean maximizedMode;
    public static Integer implicitWaitTime;
    public static Integer getExplicitWaitTime;
    public static Integer pageloadWaitTime;
    public static Boolean headless;
    public static Boolean deleteCookies;
    public static Boolean remoteRun;


    public static void initializeProperties()throws Exception{
        if (configProperties == null){
            configProperties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+("//src//test//resources//config.properties")));
            configProperties.load(fileInputStream);
        }
        runOnBrowser=configProperties.getProperty("RunOnBrowser");
        takeScreenshot=Boolean.valueOf(configProperties.getProperty("TakeScreenShot"));  //convert string into boolean
        chromeDriverPath = configProperties.getProperty("ChromeDriverPath");
        ieDriverPath=configProperties.getProperty("IEDriverPath");
        edgeDriverPath=configProperties.getProperty("EdgeDriverPath");
        fireFoxDriverPath=configProperties.getProperty("FirefoxDriverPath");
        maximizedMode=Boolean.valueOf(configProperties.getProperty("MaximizedMode"));
        implicitWaitTime=Integer.valueOf(configProperties.getProperty("ImplicitWait"));
        getExplicitWaitTime=Integer.valueOf(configProperties.getProperty("ExplicitWait"));
        pageloadWaitTime=Integer.valueOf(configProperties.getProperty("PageLoadWait"));
        headless=Boolean.valueOf(configProperties.getProperty("headless"));
        deleteCookies=Boolean.valueOf(configProperties.getProperty("deleteCookies"));
        remoteRun=Boolean.valueOf(configProperties.getProperty("remoteRun"));




    }


    public static void main(String[] args) throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
    }

}
