import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class ContactAddingPage {
    AppiumDriver driver;
    @AndroidFindBy(id="account_type")
    WebElement contactForm;
    @AndroidFindBy(xpath="//android.widget.LinearLayout/android.widget.EditText[1]")
    WebElement firstName;
    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Cancel']")
    WebElement discardButton;


    public ContactAddingPage(AppiumDriver myDriver) {
        this.driver = myDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
