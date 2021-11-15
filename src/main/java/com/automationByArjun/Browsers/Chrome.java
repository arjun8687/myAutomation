package com.automationByArjun.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Chrome extends Browser{

    ChromeOptions chromeOptions;

    @Override
    public void setPreferences() {

        chromeOptions = new ChromeOptions();

        //if (isHeadless()){                        //this will run the code without   GUI
            //chromeOptions.setHeadless(true);
        //}

        if(isMaximized()){
            chromeOptions.addArguments("start-maximized");
        }
        chromeOptions.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));//to block pop-ups

    }

    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver",path);
        if (isRemote()){
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
            if (isDeleteCookies()) {
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}
