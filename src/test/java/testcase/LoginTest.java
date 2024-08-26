package testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.LostYourPasswordPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public LostYourPasswordPage lostYourPasswordPage;
    public MyAccountPage myAccountPage;

    public LoginTest(){
        super();
    }


    @BeforeMethod
    public void preRequsite(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        lostYourPasswordPage = new LostYourPasswordPage();
        myAccountPage = new MyAccountPage();
    }


    @Test(description = "Verify login with valid username and valid password")
    public void verifyLoginWithValidUserNameValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closedAd();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        String text = myAccountPage.getTextOfMyAccount();
        softAssert.assertEquals(text, "MY ACCOUNT", "MY ACCOUNT text should be match");
        softAssert.assertAll();
    }

    @Test(description = "Verify login with valid username and invalid password")
    public void verifyLoginWithValidUserNameInvalidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closedAd();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("invalidPasswoed"));
        softAssert.assertEquals(loginPage.getTextOfError(), "ERROR", "ERROR text should be match");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
