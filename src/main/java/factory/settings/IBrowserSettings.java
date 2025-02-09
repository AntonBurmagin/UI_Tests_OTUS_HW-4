package factory.settings;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.AbstractDriverOptions;

public interface IBrowserSettings {
    AbstractDriverOptions settings(String ... optionArgs);
}
