package framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {

    public static void goToUrl(String autUrl){
        Drivercontext.driver.get(autUrl);
        Drivercontext.driver.manage().window().maximize();
    }
}
