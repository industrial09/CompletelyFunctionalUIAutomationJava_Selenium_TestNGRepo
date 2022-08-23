package seleniumTests.tests;


import framework.base.Drivercontext;
import framework.base.InitiliazeDriver;
import framework.base.Utilities;
import framework.config.ConfigReader;
import framework.config.Settings;
import framework.utilities.ExcelUtility;
import framework.utilities.LogUtility;
import framework.utilities.serverComponents.requestMethods.RestRequests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.*;

public class InitializeBrowser extends InitiliazeDriver {
    public ExcelUtility excelUtility;
    public LogUtility logUtility;
    public RestRequests restRequests;
    @BeforeMethod
    public void setup(){
        //TODO
        //Connection con = DatabaseUtility.openDBConnnection("jdbc:sqlserver://localhost:51643;databaseName=dotnet;user='';password=''");
        //String author = DatabaseUtility.executeQuery("select author from authordata where id=1", con);
        ConfigReader.ReadProperty();
        excelUtility = new ExcelUtility();
        logUtility = new LogUtility();
        restRequests = new RestRequests();
        logUtility.createLogFile();
        logUtility.write("Initializing WebDriver");
        initializeBrowser(Settings.Browser);
        excelUtility = Utilities.getExcelData();
    }

    @AfterMethod
    public void tearDown(){
        Drivercontext.driver.quit();
    }
}
