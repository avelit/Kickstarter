package ua.goit.gojava32.kickstarter.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

  public static void executeAdd(Connection con, String queryCheck, String query) {
    try (Statement st1 = con.createStatement(); Statement st2 = con.createStatement()) {
      ResultSet resultSet = st2.executeQuery(queryCheck);
      if (resultSet == null) {
        st1.executeUpdate(query);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void executeUpdate(Connection con, String query) {
    try (Statement st = con.createStatement()) {
      st.executeQuery(query);
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