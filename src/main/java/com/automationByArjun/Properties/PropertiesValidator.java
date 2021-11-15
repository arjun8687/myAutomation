package com.automationByArjun.Properties;

import com.automationByArjun.ConfigurationException;

import static com.automationByArjun.Properties.PropertiesLoader.*;

public class PropertiesValidator {

    public static void validateConfigurations()throws Exception{
        if(runOnBrowser.equalsIgnoreCase("Chrome")){
            if (chromeDriverPath.isEmpty()){
                throw new ConfigurationException("ChromeDriver Path is Empty");
            }
        } if (runOnBrowser.equalsIgnoreCase("Firefox")){
            if (fireFoxDriverPath.isEmpty()){
                throw new ConfigurationException("Firefox Path is Empty");
            }
        } if (runOnBrowser.equalsIgnoreCase("EdgeDriver")){
            if (ieDriverPath.isEmpty()){
                throw new ConfigurationException("edge driver path is empty");
            }
        }
    }


}
