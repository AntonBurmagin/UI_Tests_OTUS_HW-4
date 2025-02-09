package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbsBasePage {

    public MainPage(WebDriver driver) {
        super(driver, "");
    }


    private final By textInputLocator = By.id("textInput");


    public WebElement getTextInput () {
        return driver.findElement(textInputLocator);
    }

    public void textIntoElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void textInputShouldBeSameAs(String expectedText, WebElement inputElement) {
        Assertions.assertEquals(expectedText, inputElement.getDomProperty("value"));
    }


}
