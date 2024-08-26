package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownUtil {

    public static Select select;

    public static void selectDropDown(WebElement element, String value, String option) {
        select = new Select(element);
        if (option.equalsIgnoreCase("selectByVisibleText")) {
            select.selectByVisibleText(value);
        } else if (option.equalsIgnoreCase("selectByValue")) {
            select.selectByValue(value);
        } else {
            throw new RuntimeException("Please select correct dropdown option");
        }
    }

    public static void selectDropDown(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
    }

    public static String getAllDropDownOption(WebElement element) {
        select = new Select(element);
        String text = null;
        List<WebElement> allElements = select.getOptions();
        for (WebElement e : allElements) {
            text = e.getText();
        }
        return text;
    }
}
