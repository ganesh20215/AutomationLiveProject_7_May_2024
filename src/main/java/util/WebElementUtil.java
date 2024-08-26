package util;

import org.openqa.selenium.WebElement;
import testbase.WebTestBase;

public class WebElementUtil extends WebTestBase {

    public static String getTextOfElement(WebElement element){
        return element.getText();
    }
}
