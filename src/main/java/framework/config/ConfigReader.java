package framework.config;

import framework.base.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {
    public static void ReadProperty(){
        Properties prop = new Properties();
        try {
            String path = "C:\\Users\\Christian Bautista\\IdeaProjects\\CompletelyFunctionalRepoSeleniumWithJava\\src\\main\\java\\framework\\config\\GlobalConfig.properties";
            InputStream file = new FileInputStream(path);
            prop.load(file);
            Settings.ExcelFileLocation = prop.getProperty("ExcelFileLocation");
            Settings.LogFileLocation = prop.getProperty("LogFileLocation");
            Settings.AUTUrl = prop.getProperty("AUTUrl");
            Settings.ChromeDriverLocation = prop.getProperty("ChromeDriverLocation");
            Settings.Browser = BrowserType.valueOf((String) prop.get("BrowserType"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
