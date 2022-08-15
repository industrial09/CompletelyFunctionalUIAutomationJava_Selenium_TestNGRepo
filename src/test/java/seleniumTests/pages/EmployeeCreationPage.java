package seleniumTests.pages;

import framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeCreationPage extends BasePage {
    @FindBy(how = How.CSS, using="input[id=Name]")
    WebElement txtName;

    @FindBy(how = How.CSS, using="input[id=Salary]")
    WebElement txtSalary;

    @FindBy(how = How.CSS, using="input[id=DurationWorked]")
    WebElement txtDurationWorked;

    @FindBy(how = How.CSS, using="input[id=Grade]")
    WebElement txtGrade;

    @FindBy(how = How.CSS, using="input[id=Email]")
    WebElement txtEmail;

    @FindBy(how = How.CSS, using="input[value=Create]")
    WebElement btnCreate;

    public BasePage createNewEmployee(String name, String salary, String durationWorked, String grade, String email){
        txtName.sendKeys(name);
        txtSalary.sendKeys(salary);
        txtDurationWorked.sendKeys(durationWorked);
        txtGrade.sendKeys(grade);
        txtEmail.sendKeys(email);
        btnCreate.click();
        return GetInstance(EmployeeListPage.class);
    }
}
