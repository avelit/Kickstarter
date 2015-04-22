package ua.goit.gojava32.kickstarter.dao;

import java.sql.*;
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
    String query = String.format("UPDATE categories SET name = '%s' description = '%s' WHERE id = '%d'",
            category.getName(), category.getDescription(), category.getId());
    AbstractDAO.executeUpdate(con, query);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public Set<Category> findAll() {
    return Data.projects.keySet();
  }

  @Override
  public List<Project> findAllProjects(Category category) {
    return Data.projects.get(category);
  }

  @Override
  public List<Project> findAllProjects(Integer id) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getId().equals(id)) {
        return cat.getProjects();
      }
    }
    return null;
  }

  @Override
  public void delete(Category category) {
    Data.projects.remove(category);
  }

  @Override
  public Category get(Integer id) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getId().equals(id)) {
        return cat;
      }
    }
    return null;
  }

  @Override
  public Category get(String name) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getName().equals(name)) {
        return cat;
      }
    }
    return null;
  }
}
