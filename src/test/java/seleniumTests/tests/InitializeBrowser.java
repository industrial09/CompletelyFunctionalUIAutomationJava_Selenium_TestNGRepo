package seleniumTests.tests;


import framework.base.Drivercontext;
import framework.base.InitiliazeDriver;
import framework.base.Utilities;
import framework.config.ConfigReader;
import framework.config.Settings;
import framework.utilities.ExcelUtility;
import framework.utilities.LogUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class InitializeBrowser extends InitiliazeDriver {
    public ExcelUtility excelUtility;
    public LogUtility logUtility;
    @BeforeTest
    public void setup(){
        //TODO
        //Connection con = DatabaseUtility.openDBConnnection("jdbc:sqlserver://localhost:51643;databaseName=dotnet;user='';password=''");
        //String author = DatabaseUtility.executeQuery("select author from authordata where id=1", con);
        ConfigReader.ReadProperty();
        excelUtility = new ExcelUtility();
        logUtility = new LogUtility();
        logUtility.createLogFile();
        logUtility.write("Initializing WebDriver");
        initializeBrowser(Settings.Browser);
        excelUtility = Utilities.getExcelData();
    }

    @AfterTest
    public void tearDown(){
        Drivercontext.driver.quit();
    }
}
