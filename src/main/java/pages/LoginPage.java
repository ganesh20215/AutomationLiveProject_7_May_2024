package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.WaitHandle;
import util.WebElementUtil;

import java.util.List;

public class LoginPage extends WebTestBase {

    @FindBy(id = "username")
    WebElement userNameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginBtn;

    @FindBy(xpath = "//strong[text()='ERROR']")
    WebElement errorMessage;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String userName, String password){
        userNameTextBox.sendKeys(userName);
        passwordTextBox.sendKeys(password);
        WaitHandle.waitUntilElementToBeClickable(loginBtn);
    }

    public String getTextOfError(){
        return WebElementUtil.getTextOfElement(errorMessage);
    }
}
