package seleniumTests.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    WebDriver _driver;
    //WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(10));

    @FindBy(how = How.NAME, using = "UserName")
    WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    WebElement txtPassword;

    @FindBy(how = How.CSS, using = "input[class='btn btn-default']")
    WebElement btnLogin;

    public BasePage loginToPage(String userName, String pswd) {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(pswd);
        btnLogin.click();
        return GetInstance(LandingPage.class);
    }
}
