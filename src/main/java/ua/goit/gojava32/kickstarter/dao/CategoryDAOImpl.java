package ua.goit.gojava32.kickstarter.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.data.Data;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class CategoryDAOImpl implements CategoryDAO {

  @Override
  public void add(Category category) {
    Connection con = ConnectionPool.getConnection();
    String queryCheck = String.format("SELECT * FROM categories WHERE name = '%s'", category.getName());
    String query = String.format("INSERT INTO categories (name,description) VALUES ('%s', '%s')",
            category.getName(), category.getDescription());
    AbstractDAO.executeAdd(con, queryCheck, query);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public void update(Category category) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("UPDATE categories SET name = '%s', description = '%s' WHERE id = '%d'",
            category.getName(), category.getDescription(), category.getId());
    AbstractDAO.executeUpdate(con, query);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public Set<Category> findAll() {
    Connection con = ConnectionPool.getConnection();
    Set<Category> categorySet = AbstractDAO.getAllCategories(con);
    ConnectionPool.releaseConnection(con);
    return categorySet;
  }

  @Override
  public List<Project> findAllProjects(Category category) {
    return findAllProjects(category.getId());
  }

  @Override
  public List<Project> findAllProjects(Integer id) {
    Connection con = ConnectionPool.getConnection();
    List<Project> projectList = AbstractDAO.getAllProjects(con, id);
    ConnectionPool.releaseConnection(con);
    return projectList;
  }

  @Override
  public void delete(Integer id) {
    Connection con = ConnectionPool.getConnection();
    String query = "DELETE FROM categories WHERE id = " + id;
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
    Connection con = ConnectionPool.getConnection();
    String query = "SELECT * FROM categories WHERE id = " + id;
    Category category = AbstractDAO.getCategory(con, query);
    ConnectionPool.releaseConnection(con);
    return category;
  }

  @Override
  public Category get(String name) {
    Connection con = ConnectionPool.getConnection();
    String query = "SELECT * FROM categories WHERE name = " + name;
    Category category = AbstractDAO.getCategory(con, query);
    ConnectionPool.releaseConnection(con);
    return category;
  }
}
