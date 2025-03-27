package factory;

import exceptions.BrowserNotSupportedException;
import factory.settings.ChromeSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    private final String browser = System.getProperty("browser", "chrome");
    private final String browserVersion = System.getProperty("browser.version", "128.0");
    private final String remoteUrl = System.getProperty("remote.url");





    public WebDriver create(String ... optionsArgs) throws BrowserNotSupportedException, MalformedURLException {
        if (!remoteUrl.isEmpty()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            Map<String, Object> options = new HashMap<>();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);

            options.put(CapabilityType.BROWSER_VERSION, browserVersion);
            options.put("enableVNC", true);
            capabilities.setCapability("selenoid:options", options);

            return new RemoteWebDriver(new URL(remoteUrl), capabilities);
        }

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
