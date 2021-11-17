import com.automationByArjun.Browsers.DriverManager;
import com.automationByArjun.Components.BaseActions;
import com.automationByArjun.Components.ElementsFindBy;
import com.automationByArjun.Components.TestActions;
import com.automationByArjun.Properties.PropertiesLoader;
import com.automationByArjun.Properties.PropertiesValidator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleTest extends TestActions {

    @Test
    public  void loadBrowserTest()throws Exception{
        pageActions.typeInto("LoginPage.txtBoxUsername","Admin");
        pageActions.typeInto("LoginPage.txtBoxPassword","admin123");
        pageActions.clickIt("LoginPage.Btn_Submit");
        Thread.sleep(4000);
    }
}
