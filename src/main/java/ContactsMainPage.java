import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactsMainPage {
    AppiumDriver driver;
    @AndroidFindBy(id="floating_action_button")
    WebElement addButton;

    public ContactsMainPage(AppiumDriver myDriver) {
        this.driver = myDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
