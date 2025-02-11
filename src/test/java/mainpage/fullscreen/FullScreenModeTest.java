package mainpage.fullscreen;

import factory.WebDriverFactory;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

public class FullScreenModeTest {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;

    @BeforeAll
    static void beforeAllSettings(){
        webDriverFactory.webDriverManagerSetup();
    }

    @BeforeEach
    public void createDriverWithOptions() {
        driver = webDriverFactory.create("-fullscreen");
    }

    @Test
    public void sampleFormTest() throws InterruptedException {
        MainPage page = new MainPage(driver);
        page.open();

        String name = "Anton";
        String email = "antonio_from_StAntonio@gmail.com";

        page.fillSampleForm(name, email);
        Thread.sleep(1000);
        page.submitSampleForm();

        page.messageBoxTextShouldBe(name, email);
    }

    @AfterEach
    public void driverClose(){
        if (driver != null)
            driver.close();
    }


}
