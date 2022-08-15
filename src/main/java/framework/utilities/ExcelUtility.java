package framework.utilities;

import framework.config.ConfigReader;
import framework.config.Settings;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class ExcelUtility {
    static Sheet wrksheet;
    static Workbook wrkbook =null;
    static Hashtable dict= new Hashtable();
    //Create a Constructor
    public ExcelUtility()
    {
        //Initialize
        try {
            wrkbook = Workbook.getWorkbook(new File(Settings.ExcelFileLocation));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (BiffException e) {
            throw new RuntimeException(e);
        }
        //For Demo purpose the excel sheet name is hardcoded, but not recommended :)
        wrksheet = wrkbook.getSheet("Sheet1");

        //Call the Column Dictionary to store column Names
        ColumnDictionary();
    }

    //Returns the Number of Rows
    public static int RowCount()
    {
        return wrksheet.getRows();
    }

    //Returns the Cell value by taking row and Column values as argument
    private static String ReadCell(int column,int row)
    {
        return wrksheet.getCell(column,row).getContents();
    }

    public static String ReadCell(String columnName, int rowNumber)
    {
        return ReadCell(GetCell(columnName), rowNumber);
    }

    //Create Column Dictionary to hold all the Column Names
    private static void ColumnDictionary()
    {
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        for(int col=0;col < wrksheet.getColumns();col++)
        {
            dict.put(ReadCell(col,0), col);
        }
    }

    //Read Column Names
    private static int GetCell(String colName)
    {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);

        }
    }
}
