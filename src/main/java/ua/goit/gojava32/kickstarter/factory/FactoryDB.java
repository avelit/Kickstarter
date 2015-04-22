package ua.goit.gojava32.kickstarter.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FactoryDB {

  public static void createDB() {
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:kickstarter.db"); Statement stmt = conn.createStatement();) {
      try {
        stmt.execute("SELECT * FROM categories");
      } catch (SQLException e) {
        String sql = "CREATE TABLE IF NOT EXISTS categories " +
                "(id INT PRIMARY KEY," +
                "name           TEXT, " +
                "description    TEXT)";
        stmt.executeUpdate(sql);

        sql = "insert into categories (name,description) values ('Music','Music')";
        stmt.executeUpdate(sql);
        sql = "insert into categories (name,description) values ('Medicine','Medicine')";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS project " +
                "(id INT PRIMARY KEY," +
                "name           TEXT, " +
                "id_category     INT," +
                "description    TEXT," +
                "FOREIGN KEY(id_category)  REFERENCES categories(id))" +

                stmt.executeUpdate(sql);
      }
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
