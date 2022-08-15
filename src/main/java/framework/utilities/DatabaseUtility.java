package framework.utilities;

import java.sql.*;

public class DatabaseUtility {
    public static Connection openDBConnnection(String connectionString){
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            con = DriverManager.getConnection(connectionString);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void openDBConnnection(Connection con){
        try{
            con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public static String executeQuery(String query, Connection con){
        Statement statement=null;
        String author=null;
        try{
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                author = String.valueOf(resultSet.first());
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return author;
    }
}
