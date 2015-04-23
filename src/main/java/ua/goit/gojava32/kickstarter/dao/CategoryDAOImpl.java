package ua.goit.gojava32.kickstarter.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class CategoryDAOImpl implements CategoryDAO {

  @Override
  public void add(Category category) {
    Connection con = ConnectionPool.getConnection();
    String queryCheck = String.format("SELECT * FROM categories WHERE name = '%s'", category.getName());
    String query = String.format("INSERT INTO categories (name,description) VALUES ('%s', '%s')", category.getName(), category.getDescription());
    try (Statement st1 = con.createStatement(); Statement st2 = con.createStatement()) {
      ResultSet resultSet = st2.executeQuery(queryCheck);
      if (!resultSet.next()) {
        st1.executeUpdate(query);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public void update(Category category) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("UPDATE categories SET name = '%s', description = '%s' WHERE id = '%d'",
            category.getName(), category.getDescription(), category.getId());
    try (Statement st = con.createStatement()) {
      st.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public Set<Category> findAll() {
    Connection con = ConnectionPool.getConnection();
    String query = "SELECT * FROM categories";
    Set<Category> categorySet = new HashSet<>();
    try (Statement st = con.createStatement()) {
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {
        Integer id = rs.getInt("id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        categorySet.add(FactoryModel.createCategory(id, name, description));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
    return categorySet;
  }

  @Override
  public List<Project> findAllProjects(Category category) {
    return findAllProjects(category.getId());
  }

  @Override
  public List<Project> findAllProjects(Integer categoryId) {
    Connection con = ConnectionPool.getConnection();
    List<Project> projectList = new ArrayList<>();
    try (Statement st = con.createStatement()) {
      String query = String.format("SELECT * FROM projects WHERE id_category = '%d'", categoryId);
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
    ConnectionPool.releaseConnection(con);
    return projectList;
  }

  @Override
  public void delete(Integer id) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("DELETE FROM categories WHERE id = '%d'", id);
    try (Statement st = con.createStatement()) {
      st.executeUpdate(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public void delete(Category category) {
    delete(category.getId());
  }

  @Override
  public Category get(Integer id) {
    String query = String.format("SELECT * FROM categories WHERE id = '%d'", id);
    Category category = getCategory(query);
    return category;
  }

  @Override
  public Category get(String name) {
    String query = String.format("SELECT * FROM categories WHERE name = '%s'", name);
    Category category = getCategory(query);
    return category;
  }
  
  public static Category getCategory(String query) {
    Connection con = ConnectionPool.getConnection();
    Category category = null;
    try (Statement st = con.createStatement()) {
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {
        Integer id = rs.getInt("id");
        String description = rs.getString("description");
        String name = rs.getString("name");
        category = FactoryModel.createCategory(id, name, description);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
    return category;
  }
} 
