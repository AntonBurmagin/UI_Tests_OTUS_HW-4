package factory;

import exceptions.BrowserNotSupportedException;
import factory.settings.ChromeSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private final String browser = System.getProperty("browser");


    public WebDriver create(String ... optionsArgs) throws BrowserNotSupportedException {
        return switch (browser) {
            case "chrome" -> new ChromeDriver((ChromeOptions) new ChromeSettings().settings(optionsArgs));
            case "firefox" -> new FirefoxDriver();
            case "safari" -> new SafariDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new BrowserNotSupportedException(browser);
        };
    }

    public void webDriverManagerSetup(){
        switch (browser) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                break;
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                break;
            }
            case "safari": {
                WebDriverManager.safaridriver().setup();
                break;
            }
            case "edge": {
                WebDriverManager.edgedriver().setup();
                break;
            }
            default: {
                throw new BrowserNotSupportedException(browser);
            }
        }
    }



}
