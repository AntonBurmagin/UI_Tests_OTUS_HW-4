package mainpage.kiosk;

import factory.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.net.MalformedURLException;


public class KioskModeTest {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;

    @BeforeAll
    public static void beforeAllSettings() {
        webDriverFactory.webDriverManagerSetup();
    }

//    Открыть Chrome в режиме киоска
//    Перейти на ресурс
//    Нажать на "Открыть модальное окно"
//    Проверить что открылось модальное окно
    @BeforeEach
    public void createDriverWithOptions() throws MalformedURLException {
        driver = webDriverFactory.create("--kiosk");
    }

    @Test
    public void modalBtnTest() throws InterruptedException {
        MainPage page = new MainPage(driver);
        page.open();

        page.modalAlertShouldNotBeDisplayed();

        page.getModalButton().click();

        page.modalAlertShouldBeDisplayed();
    }

    @AfterEach
    public void driverClose(){
        if (driver != null)
            driver.close();
    }

}
