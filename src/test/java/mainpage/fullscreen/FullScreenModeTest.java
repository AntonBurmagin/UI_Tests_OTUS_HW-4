package mainpage.fullscreen;

import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class FullScreenModeTest {
    private static WebDriverFactory webDriverFactory = new WebDriverFactory();
    private WebDriver driver;

    @BeforeAll
    public static void beforeAllSettings() {  //?????
        WebDriverManager.chromedriver().setup();
    }

//    Открыть Chrome в режиме киоска
//    Перейти на ресурс
//    Нажать на "Открыть модальное окно"
//    Проверить что открылось модальное окно
    @BeforeEach
    public void createPage(){
        driver = webDriverFactory.create("");
    }

    @Test
    public void modalBtnTest() throws InterruptedException {
        MainPage page = new MainPage(driver);
        page.open();

//        if (driver == null)
//            System.out.println("NULLLLLLLL");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.pollingEvery(Duration.ofMillis(200));
//        WebElement btn = driver.findElement(By.id("openModalBtn"));
////        System.out.println(driver.findElement(By.id("myModal")).findElement(By.tagName("")));
////        btn.click();
//        System.out.println(driver.findElement(By.id("myModal")).getText());
//        Thread.sleep(5000);

//        Assertions.assertEquals();
    }

    @AfterEach
    public void driverClose(){
        if (driver != null)
            driver.close();
    }

}
