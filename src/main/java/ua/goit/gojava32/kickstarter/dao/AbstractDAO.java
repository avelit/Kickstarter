package ua.goit.gojava32.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

  public static void executeAdd(Connection con, String query, String queryCheck) {
    try (Statement stUpdate = con.createStatement(); Statement stCheck = con.createStatement()) {
      ResultSet resultSet = stCheck.executeQuery(queryCheck);
      if (!resultSet.next()) {
        stUpdate.executeUpdate(query);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void executeUpdate(Connection con, String query) {
    try (Statement st = con.createStatement()) {
      st.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
