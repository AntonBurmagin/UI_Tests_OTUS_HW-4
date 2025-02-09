package mainpage.headless;

import factory.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

public class HeadlessModeTest {
    private static WebDriverFactory webDriverFactory = new WebDriverFactory();
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
    public void createDriverWithOptions (){
        driver = webDriverFactory.create("--headless");
    }
    // нет открытия вкладок из-за хэдлесс режима????

    @Test
    public void textInputTest() throws InterruptedException {
        MainPage page = new MainPage(driver);
        page.open();
        Thread.sleep(1000);

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
