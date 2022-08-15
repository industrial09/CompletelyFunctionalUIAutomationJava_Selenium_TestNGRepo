package seleniumTests.tests;


import org.testng.annotations.Test;
import seleniumTests.pages.*;

public class LoginTests extends InitializeBrowser {
    @Test
    public void validateSuccefulLogIn(){
        CurrentPage = GetInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).clickOnLogInLink();
        CurrentPage = CurrentPage.As(LoginPage.class).loginToPage(excelUtility.ReadCell("UserName", 1), excelUtility.ReadCell("Password",1));
        CurrentPage.As(LandingPage.class).validateSuccessfulLogIn();
    }
}
