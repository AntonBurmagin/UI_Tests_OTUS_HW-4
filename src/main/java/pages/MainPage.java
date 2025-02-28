package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPage extends AbsBasePage {
    private final WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    private static final Logger logger = LogManager.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver, "");
    }


    private final By textInputId = By.id("textInput");
    private final By modalBtnId = By.id("openModalBtn");
    private final By modalBtnAlertId = By.id("myModal");
    private final By sampleFormInputNameLocator = By.xpath("//form/input[@name='name']");
    private final By sampleFormEmailInputSelector = By.cssSelector("input#email");
    private final By sampleFormSubmitBtnLocator = By.xpath("//form/button[@type='submit']");
    private final By messageBoxId = By.id("messageBox");


    public void fillSampleForm(String name, String email) {
        if (name == null || email == null){
            logger.error("Name or email is null!");
        }
        driver.findElement(sampleFormInputNameLocator).sendKeys(name);
        driver.findElement(sampleFormEmailInputSelector).sendKeys(email);
    }

    public void submitSampleForm(){
        driver.findElement(sampleFormSubmitBtnLocator).click();
    }

    public WebElement getMessageBox(){
        return driver.findElement(messageBoxId);
    }

    public void messageBoxTextShouldBeSameAs(String expected) {
        String actual = this.getMessageBox().getText();
        assertThat(actual).isEqualTo(expected);
    }



    public WebElement getTextInput () {
        return driver.findElement(textInputId);
    }

    public void textIntoElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void textInputShouldBeSameAs(String expectedText, WebElement inputElement) {
        assertThat(inputElement.getDomProperty("value")).isEqualTo(expectedText);
    }


    public WebElement getModalButton () {
        return driver.findElement(modalBtnId);
    }

    public WebElement getModalAlert () {
        return driver.findElement(modalBtnAlertId);
    }

    public void modalAlertShouldNotBeDisplayed() {
        try {
            waiter.until(ExpectedConditions.invisibilityOf(getModalAlert()));
        } catch (TimeoutException exception) {
            logger.error("Timeout exception in modalAlertShouldNotBeDisplayed()");
        } finally {
            assertThat(getModalAlert().isDisplayed()).isFalse();
        }
    }

    public void modalAlertShouldBeDisplayed() {
        try {
            waiter.until(ExpectedConditions.visibilityOf(getModalAlert()));
        } catch (TimeoutException exception) {
            logger.error("Timeout exception in modalAlertShouldBeDisplayed()");
        } finally {
            assertThat(getModalAlert().isDisplayed()).isTrue();
        }
    }

}
