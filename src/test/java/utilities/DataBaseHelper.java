package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper {
    private static Connection connection;
    public static Statement statement;

    public static List<List<String>> getData(String select){
        DbConnectionOpen();
        List<List<String>> getData=new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(select);

            ResultSetMetaData rsmd = resultSet.getMetaData();

            while (resultSet.next()) {
                List<String> row =new ArrayList<>();

                for (int j = 1; j <= rsmd.getColumnCount(); j++) {
                    row.add(resultSet.getString(j)+"\t ");
                }

                getData.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DbConnectionClose();
        return getData;
    }

    public static void bufferWriter(String path , String Sql){
        List<List<String>> data = getData(Sql);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (List<String> row : data) {
                writer.write(String.join(" - ", row));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void DbConnectionOpen() {
        String URL = ConfigReader.getProperty("URL");
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        try {
            connection = DriverManager.getConnection(URL, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DbConnectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
