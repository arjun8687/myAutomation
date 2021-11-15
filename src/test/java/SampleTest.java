import com.automationByArjun.Browsers.DriverManager;
import com.automationByArjun.Components.ElementsFindBy;
import com.automationByArjun.Properties.PropertiesLoader;
import com.automationByArjun.Properties.PropertiesValidator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public  void loadBrowserTest()throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        DriverManager driverManager = new DriverManager();
        driverManager.loadDriver();
        DriverManager.driver.get("http://www.google.com");
        Thread.sleep(2000);
        ElementsFindBy findBy = new ElementsFindBy(DriverManager.driver);
        WebElement element = findBy.findElementBy("GooglePage.tbxSearch");
        element.sendKeys("Testing Framework");
        Thread.sleep(5000);
        driverManager.closeBrowser();
    }
}
