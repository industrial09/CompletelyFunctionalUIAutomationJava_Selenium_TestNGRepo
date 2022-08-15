package framework.base;

import framework.config.ConfigReader;
import framework.config.Settings;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Map;

public class InitiliazeDriver extends BasePage{
    public void initializeBrowser(BrowserType browserType){
        switch(browserType){
            case Chrome:
                System.setProperty("webdriver.chrome.driver", Settings.ChromeDriverLocation);
                Drivercontext.driver = new ChromeDriver();
                Browser.goToUrl(Settings.AUTUrl);
                break;
            case Firefox:
                Drivercontext.driver = new FirefoxDriver();
                Browser.goToUrl(Settings.AUTUrl);
                break;
            case IE:
                Drivercontext.driver = new InternetExplorerDriver();
                Browser.goToUrl(Settings.AUTUrl);
                break;
            default:
                System.out.println("Select a valid browser");
                break;
        }
    }
}
