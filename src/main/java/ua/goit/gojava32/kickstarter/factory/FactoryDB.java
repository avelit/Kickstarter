package ua.goit.gojava32.kickstarter.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FactoryDB {

  public static final String CONNECTION_STRING = "jdbc:sqlite:kickstarter.db";
  
  public static void createDB() {
    try (Connection conn = DriverManager.getConnection(CONNECTION_STRING); Statement stmt = conn.createStatement();) {
      try {
        stmt.execute("SELECT * FROM categories");
      } catch (SQLException e) {
        String sql = "CREATE TABLE IF NOT EXISTS categories " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name           TEXT, " +
            "description    TEXT)";
        stmt.executeUpdate(sql);

        sql = "insert into categories (name,description) values ('Music','Music')";
        stmt.executeUpdate(sql);
        sql = "insert into categories (name,description) values ('Medicine','Medicine')";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS projects " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name           TEXT, " +
            "id_category     INTEGER," +
            "id_author     INTEGER," +
            "description    TEXT," +
            "FOREIGN KEY(id_author)  REFERENCES users(id)," + 
            "FOREIGN KEY(id_category)  REFERENCES categories(id))";

        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS comments " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "author           TEXT, " +
            "id_project     INTEGER," +
            "comment    TEXT," +
            "FOREIGN KEY(id_project)  REFERENCES projects(id))";

        stmt.executeUpdate(sql);
        
        sql = "CREATE TABLE IF NOT EXISTS blogs " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "author           TEXT, " +
            "id_project     INTEGER," +
            "comment    TEXT," +
            "FOREIGN KEY(id_project)  REFERENCES projects(id))";

        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS users " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "user           TEXT, " +
            "token     TEXT," +
            "email     TEXT," +
            "comment    TEXT," +
            "active    INTEGER)";

        stmt.executeUpdate(sql);
      }
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
