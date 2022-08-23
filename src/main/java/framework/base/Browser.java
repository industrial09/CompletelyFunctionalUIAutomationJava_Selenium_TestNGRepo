package framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {
    //This class can contain another browser methods like NavigateTo
    public static void goToUrl(String autUrl){
        Drivercontext.driver.get(autUrl);
        Drivercontext.driver.manage().window().maximize();
    }
}
