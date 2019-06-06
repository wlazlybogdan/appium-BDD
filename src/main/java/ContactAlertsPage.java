import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactAlertsPage {
        AppiumDriver driver;
        @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Take a minute')]")
        WebElement googleAccountAlert;
        @AndroidFindBy(id = "left_button")
        WebElement cancelButton;
        @AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'Discard changes?')]")
        WebElement contactDiscardAlert;


        public ContactAlertsPage(AppiumDriver myDriver) {
            this.driver = myDriver;
            PageFactory.initElements(new AppiumFieldDecorator(driver),this);

        }


    }

