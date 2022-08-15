package framework.base;

import framework.config.ConfigReader;
import framework.utilities.ExcelUtility;

import java.util.Map;

public class Utilities {
    public static ExcelUtility getExcelData(){
        ExcelUtility util=null;
        try {
             util = new ExcelUtility();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return util;
    }
}
