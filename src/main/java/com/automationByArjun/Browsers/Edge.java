package com.automationByArjun.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Edge extends Browser{

    EdgeOptions edgeOptions;

    @Override
    public void setPreferences() {

        edgeOptions = new EdgeOptions();

        edgeOptions.setCapability("excludeSwitches", Arrays.asList("disable-popup-blocking"));//to block pop-ups

    }

    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver = null;
        System.setProperty("webdriver.edge.driver",path);
        if (isRemote()){
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),edgeOptions);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            driver = new EdgeDriver(edgeOptions);

            if (isMaximized()){
                driver.manage().window().maximize();
            }

            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
            if (isDeleteCookies()) {
                driver.manage().deleteAllCookies();
            }
        }
        return driver;
    }
}
