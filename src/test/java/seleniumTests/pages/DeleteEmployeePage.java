package seleniumTests.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeleteEmployeePage extends BasePage {
    @FindBy(how = How.LINK_TEXT, using ="Home")
    WebElement linkHome;

    @FindBy(how = How.LINK_TEXT, using ="About")
    WebElement linkAbout;

    @FindBy(how = How.LINK_TEXT, using ="Employee List")
    WebElement linkEmployeeList;

    @FindBy(how = How.LINK_TEXT, using ="Employee Details")
    WebElement linkEmployeeDetails;

    @FindBy(how = How.LINK_TEXT, using ="Manage Users")
    WebElement linkLogManageUsers;

    @FindBy(how = How.LINK_TEXT, using ="Log off")
    WebElement linkLogOff;

    @FindBy(how = How.XPATH, using="//a[contains(text(), 'Hello admin')]")
    WebElement lblSuccessLogIn;

    @FindBy(how = How.CSS, using="input[value=Delete]")
    WebElement btnDelete;

    public BasePage deleteEmployee(){
        btnDelete.click();
        return GetInstance(EmployeeListPage.class);
    }
}
