package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionTest {

  private static Properties properties = null;
  private static Connection connection = null;
  private static final String DB_DRIVER="db.Class.forName";
  private static final String DB_USER = "db.username";
  private static final String DB_PWD = "db.password";
  private static final String DB_URL = "db.url";
  private static final String DB_SERVER = "db.server";
  private static final String DB_NAME = "db.name";

  static{
    try {
      properties = new Properties();
      properties.load(new FileInputStream("src/test/resources/application.properties"));
      Class.forName(properties.getProperty(DB_DRIVER));
      connection= DriverManager.getConnection(properties.getProperty(DB_URL),properties.getProperty(DB_USER), properties.getProperty(DB_PWD));
    } catch (SQLException | ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }
  public static Connection getConnection(){
    return connection;
  }
  public static void main(String[] args) {
    System.out.println("Here");
    try {
      Connection connection = getConnection();
      if (connection != null) {
        System.out.println("Yessir!");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

  }
}
