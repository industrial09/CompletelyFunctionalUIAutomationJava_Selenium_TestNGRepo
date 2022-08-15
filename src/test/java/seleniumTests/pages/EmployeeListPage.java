package seleniumTests.pages;

import framework.base.BasePage;
import framework.base.Drivercontext;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmployeeListPage extends BasePage {
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

    @FindBy(how = How.LINK_TEXT, using="Create New")
    WebElement btnCreateNew;

    @FindBy(how = How.CSS, using="input[name=searchTerm]")
    WebElement txtSearchName;

    @FindBy(how = How.CSS, using="input[value=Search]")
    WebElement btnSearchName;

    @FindBy(how = How.XPATH, using="//table//tr[2]/td[1]")
    List<WebElement> lblEmployeeName;

    @FindBy(how = How.LINK_TEXT, using="Delete")
    WebElement linkDelete;

    public BasePage createNewEmployee(){
        btnCreateNew.click();
        return GetInstance(EmployeeCreationPage.class);
    }

    public BasePage deleteEmployee(){
        linkDelete.click();
        return GetInstance(DeleteEmployeePage.class);
    }

    private void searchForAnEmployee(String name){
        txtSearchName.sendKeys(name);
        btnSearchName.click();
    }

    public BasePage searchForAndDeleteAnEmployee(String name){
        searchForAnEmployee(name);
        linkDelete.click();
        return GetInstance(DeleteEmployeePage.class);
    }

    public BasePage validateEmployeeIsCreated(String name){
        searchForAnEmployee(name);
        Assert.assertTrue("Employee name wasn't created", lblEmployeeName.get(0).getText().contains(name));
        Drivercontext.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return GetInstance(EmployeeListPage.class);
    }

    public BasePage validateEmployeeIsDeleted(String name){
        searchForAnEmployee(name);
        Assert.assertTrue("Employee name wasn't deleted", lblEmployeeName.size() == 0);
        Drivercontext.driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return GetInstance(EmployeeListPage.class);
    }
}
