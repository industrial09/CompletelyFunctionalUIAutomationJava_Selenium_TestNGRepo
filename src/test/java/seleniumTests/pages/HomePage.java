package seleniumTests.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    @FindBy(how = How.LINK_TEXT, using ="Login")
    WebElement linkLogin;

    @FindBy(how = How.LINK_TEXT, using ="Register")
    WebElement linkRegister;

    @FindBy(how = How.LINK_TEXT, using ="Employee List")
    WebElement linkEmployeeList;

    @FindBy(how = How.LINK_TEXT, using ="Home")
    WebElement linkHome;

    @FindBy(how = How.LINK_TEXT, using ="About")
    WebElement linkAbout;

    public BasePage clickOnLogInLink(){
        linkLogin.click();
        return GetInstance(LoginPage.class);
    }
}
