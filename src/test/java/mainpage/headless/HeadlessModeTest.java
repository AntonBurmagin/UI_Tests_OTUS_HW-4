package mainpage.headless;

import factory.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

import java.net.MalformedURLException;

public class HeadlessModeTest {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;

    @BeforeAll
    static void beforeAllSettings(){
        webDriverFactory.webDriverManagerSetup();
    }
    //    Открыть Chrome в headless режиме
    //    Перейти на ресурс
    //    В поле ввода текста ввести ОТУС
    //    Проверить что Текст соответствует введенному

    @BeforeEach
    public void createDriverWithOptions () throws MalformedURLException {
        driver = webDriverFactory.create("--headless");
    }

    @Test
    public void textInputTest() {
        MainPage page = new MainPage(driver);
        page.open();

        WebElement textInputEl = page.getTextInput();
        page.textIntoElement(textInputEl, "ОТУС");
        page.textInputShouldBeSameAs("ОТУС", textInputEl);
    }


    @AfterEach
    public void driverClose(){
        if (driver != null)
            driver.close();
    }
}
