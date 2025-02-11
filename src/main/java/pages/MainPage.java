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
    private final By modalBtnLocator = By.id("openModalBtn");
    private final By modalBtnAlertLocator = By.id("myModal");
    private final By sampleFormLocator = By.id("sampleForm");
    private final By sampleFormInputNameLocator = By.xpath("//form/input[@name='name']");
    private final By sampleFormEmailInputSelector = By.cssSelector("input#email");
    private final By sampleFormSubmitBtnLocator = By.xpath("//form/button[@type='submit']");
    private final By messageBoxSelector = By.id("messageBox");

    public WebElement getSampleForm () {
        return driver.findElement(sampleFormLocator);
    }

    public WebElement getSampleFormNameInput() {
        return driver.findElement(sampleFormInputNameLocator);
    }

    public WebElement getSampleFormEmailInput() {
        return driver.findElement(sampleFormEmailInputSelector);
    }

    public void fillSampleForm(String name, String email) {
        driver.findElement(sampleFormInputNameLocator).sendKeys(name);
        driver.findElement(sampleFormEmailInputSelector).sendKeys(email);
    }

    public void submitSampleForm(){
        driver.findElement(sampleFormSubmitBtnLocator).click();
    }

    public WebElement getMessageBox(){
        return driver.findElement(messageBoxSelector);
    }

    public void messageBoxTextShouldBe(String nameSend, String emailSend) {
        String expected = String.format("Форма отправлена с именем: %s и email: %s", nameSend, emailSend);
        String actual = this.getMessageBox().getText();
        Assertions.assertEquals(expected, actual);
    }



    public WebElement getTextInput () {
        return driver.findElement(textInputLocator);
    }

    public void textIntoElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void textInputShouldBeSameAs(String expectedText, WebElement inputElement) {
        Assertions.assertEquals(expectedText, inputElement.getDomProperty("value"));
    }

    //modalButton
    public WebElement getModalButton () {
        return driver.findElement(modalBtnLocator);
    }

    public WebElement getModalAlert () {
        return driver.findElement(modalBtnAlertLocator);
    }

    public void modalAlertShouldBeDisplayed(WebElement modalAlert) {
        Assertions.assertTrue(modalAlert.isDisplayed());
    }

}
