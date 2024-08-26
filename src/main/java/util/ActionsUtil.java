package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.WebTestBase;

public class ActionsUtil extends WebTestBase {

    public static Actions actions;

    public static void moveToTheWebElement(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element);
    }
}
