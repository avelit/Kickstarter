package ua.goit.gojava32.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

  public static void executeAdd(Connection con, String queryCheck, String query) {
    try (Statement st = con.createStatement(); Statement ps = con.createStatement()) {
      ResultSet resultSet = ps.executeQuery(queryCheck);
      if (resultSet == null) {
        st.executeUpdate(query);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public static ResultSet executeSelect(Connection con, String query) {
    try (Statement st = con.createStatement()) {
      return st.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
