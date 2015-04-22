package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class FactoryDB {

  public static void createDB() {

    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:kickstarter.db"); Statement stmt = conn.createStatement();) {
      String sql = "CREATE TABLE categories " +
          "(id INT PRIMARY KEY     NOT NULL," +
          " name           TEXT    NOT NULL, " + 
          " description    TEXT    )"; 
      stmt.executeUpdate(sql);  
      
      sql = "CREATE TABLE project " +
          "(id INT PRIMARY KEY     NOT NULL," +
          " name           TEXT    NOT NULL, " +
          "id_category     INT ," +//FOREIGN KEY  REFERENCES categories(id)," +
          "description    TEXT    )"; 
      stmt.executeUpdate(sql);
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
  }
  
}
