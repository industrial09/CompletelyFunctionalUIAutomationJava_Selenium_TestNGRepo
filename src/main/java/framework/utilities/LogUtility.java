package framework.utilities;

import framework.config.Settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LogUtility {
    //File format for the log name
    ZonedDateTime time = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = time.format(formatter);

    private BufferedWriter bufferedWriter=null;

    //Create Log file
    public void createLogFile(){
        try{
            File file = new File(Settings.LogFileLocation);
            if(!file.exists()) file.mkdir();
            //Create Log file
            String appendFormat = "/"+fileNameFormat+".log";
            File logFile = new File(file+appendFormat);
            FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Write msg into Log file
    public void write(String msg){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
            String fileNameFormat = time.format(formatter);
            bufferedWriter.write("["+fileNameFormat+"]"+ msg);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
