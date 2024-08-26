package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.WaitHandle;

public class HomePage extends WebTestBase {

    @FindBy(xpath = "//button[@title='Close']")
    WebElement closedFirstAd;

    @FindBy(xpath = "//a[@class='newsletter__close newsletter__trigger']")
    WebElement closedSecondAd;

    @FindBy(xpath = "//a[@class='user-controls__ul__li__a']")
    WebElement loginBtn;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public void closedAd(){
        WaitHandle.waitUntilElementToBeClickable(closedFirstAd);
        WaitHandle.waitUntilElementToBeClickable(closedSecondAd);
        WaitHandle.waitUntilElementToBeClickable(loginBtn);
    }
}
