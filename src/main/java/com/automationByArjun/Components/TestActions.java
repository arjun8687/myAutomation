package com.automationByArjun.Components;

import com.automationByArjun.Browsers.DriverManager;
import com.automationByArjun.Properties.PropertiesLoader;
import com.automationByArjun.Properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestActions {
    WebDriver driver;
    DriverManager driverManager;
    public BaseActions pageActions;


        @BeforeSuite
        public void setUpConfigurations() throws Exception{//to initialize configurations
            PropertiesLoader.initializeProperties();
            PropertiesValidator.validateConfigurations();
            driverManager = new DriverManager();

        }

        @BeforeMethod
        public void setUpBrowser() throws Exception{
            driverManager.loadDriver();
            driver = driverManager.getDriver();
            BaseActions pageActions = new BaseActions(driver);
            pageActions.launchUrl(PropertiesLoader.appUrl);
        }


        @AfterMethod
        public void tearDownBrowser(){
           driverManager.closeBrowser();
        }

        @AfterSuite
        public void tearDownObjects() throws Exception{
            PropertiesLoader.configProperties = null;

        }
    }

