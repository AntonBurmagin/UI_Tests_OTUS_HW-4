package mainpage.fullscreen;

import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.io.IOException;

public class FullScreenModeTest {
    private static final WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver = null;
    private static final Logger logger = LogManager.getLogger(FullScreenModeTest.class);

    @BeforeAll
    static void beforeAllSettings(){
        webDriverFactory.webDriverManagerSetup();
    }

    @BeforeEach
    public void createDriverWithOptions() {
        driver = webDriverFactory.create("--start-fullscreen");
    }

    @Test
    public void sampleFormTest() throws IOException {
        MainPage page = new MainPage(driver);
        page.open();

        String name = "Anton";
        String email = "antonio_from_StAntonio@gmail.com";

        page.fillSampleForm(name, email);
        page.submitSampleForm();

        String expected = String.format("Форма отправлена с именем: %s и email: %s", name, email);
        page.messageBoxTextShouldBeSameAs(expected);
    }

    @AfterEach
    public void driverClose(){
        if (driver != null)
            driver.close();
    }


}
