package seleniumTests.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTests.pages.*;

public class EmployeeListTests extends InitializeBrowser{
    @Test
    public void validateEmployeeCreation(){
        CurrentPage = GetInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).clickOnLogInLink();
        CurrentPage = CurrentPage.As(LoginPage.class).loginToPage(excelUtility.ReadCell("UserName", 1), excelUtility.ReadCell("Password",1));
        CurrentPage = CurrentPage.As(LandingPage.class).clickOnEmployeeListLink();
        CurrentPage = CurrentPage.As(EmployeeListPage.class).createNewEmployee();
        CurrentPage = CurrentPage.As(EmployeeCreationPage.class).createNewEmployee(restRequests.getSingleUser(), "30000", "8", "5", "QA@gmail.com");
        CurrentPage.As(EmployeeListPage.class).validateEmployeeIsCreated(restRequests.getSingleUser());
    }

    @Test(dependsOnMethods = { "validateEmployeeCreation" })
    public void validateEmployeeDeletion(){
        /*CurrentPage = GetInstance(HomePage.class);
        CurrentPage = CurrentPage.As(HomePage.class).clickOnLogInLink();
        CurrentPage = CurrentPage.As(LoginPage.class).loginToPage(excelUtility.ReadCell("UserName", 1), excelUtility.ReadCell("Password",1));
        CurrentPage = CurrentPage.As(LandingPage.class).clickOnEmployeeListLink();*/
        CurrentPage = CurrentPage.As(EmployeeListPage.class).deleteEmployee();
        //CurrentPage = CurrentPage.As(EmployeeListPage.class).searchForAndDeleteAnEmployee("Chano");
        CurrentPage = CurrentPage.As(DeleteEmployeePage.class).deleteEmployee();
        CurrentPage.As(EmployeeListPage.class).validateEmployeeIsDeleted(restRequests.getSingleUser());
    }
}
