package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public static List<Project> getAllProjects(Connection con, Integer categoryId) {
    List<Project> projectList = new ArrayList<>();
    try (Statement st = con.createStatement()) {
      String query = "SELECT * FROM projects WHERE id_category = " + categoryId;
      ResultSet result = st.executeQuery(query);
      while (result.next()) {
        Integer id = result.getInt("id");
        String name = result.getString("name");
        String description = result.getString("description");
        projectList.add(new Project(id, name, description, categoryId));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return projectList;
  }

  public static ResultSet executeSelect(Connection con, String query) {
    try (Statement st = con.createStatement()) {
      return st.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static Set<Category> getAllCategories(Connection con) {
    Set<Category> categorySet = new HashSet<>();
    try (Statement st = con.createStatement()) {
      String query = "SELECT * FROM categories";
      ResultSet result = st.executeQuery(query);
      while (result.next()) {
        Integer id = result.getInt("id");
        String name = result.getString("name");
        String description = result.getString("description");
        categorySet.add(new Category(id, name, description));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return categorySet;
  }

  public static Category getCategory(Connection con, String query) {
    try (Statement st = con.createStatement()) {
      ResultSet result = st.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
}