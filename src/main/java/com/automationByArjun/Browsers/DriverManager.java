package com.automationByArjun.Browsers;

import com.automationByArjun.Properties.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

   public static WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public void loadDriver(){

        Browser browser=null;
        String path = "";

        if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Chrome")){
            browser = new Chrome();//runtime polymorphism
            path = PropertiesLoader.chromeDriverPath;
        }else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Edge")){
            browser = new Edge();
            path= PropertiesLoader.edgeDriverPath;
        }else if (PropertiesLoader.runOnBrowser.equalsIgnoreCase("Firefox")) {
            browser = new Firefox();
            path = PropertiesLoader.fireFoxDriverPath;
        }
        browser.setHeadless(PropertiesLoader.headless);
        browser.setRemote(PropertiesLoader.remoteRun);
        browser.setMaximized(PropertiesLoader.maximizedMode);
        browser.setPageLoadTimeout(PropertiesLoader.pageloadWaitTime);
        browser.setPreferences();
        WebDriver driver = browser.loadBrowser(path);
        setDriver(driver);
    }

    public  void closeBrowser(){
        driver.close();
    }
    public void closeAllBrowsers(){
        driver.quit();
    }
}
