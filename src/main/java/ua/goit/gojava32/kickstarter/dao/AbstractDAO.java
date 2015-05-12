package ua.goit.gojava32.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

  public static Integer executeAdd(Connection con, String query, String queryCheck) {
    Integer id = 0;
    try (Statement stUpdate = con.createStatement(); Statement stCheck = con.createStatement()) {
      ResultSet resultSet = stCheck.executeQuery(queryCheck);
      if (!resultSet.next()) {
        int affectedRows = stUpdate.executeUpdate(query);

        if (affectedRows == 0) {
          throw new SQLException("Creating user failed, no rows affected.");
        }

        try (ResultSet generatedKeys = stUpdate.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            id = generatedKeys.getInt(1);
          }
          else {
            throw new SQLException("Creating user failed, no ID obtained.");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return id;
  }

  public static void executeAdd(Connection con, String query) {
    try (Statement stUpdate = con.createStatement()) {
       stUpdate.executeUpdate(query);
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
