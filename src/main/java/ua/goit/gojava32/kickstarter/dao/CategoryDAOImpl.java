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
    String queryCheck = "SELECT * FROM categories WHERE name = ?";
    try (Statement st = con.createStatement(); PreparedStatement ps = con.prepareStatement(queryCheck)) {
      ps.setString(1, category.getName());
      ResultSet resultSet = ps.executeQuery();
      if (resultSet == null) {
        String sql = String.format("INSERT INTO categories (name,description) VALUES ('%s', '%s')",
                category.getName(), category.getDescription());
        st.executeUpdate(sql);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public void update(Category category) {
    if (Data.projects.keySet().contains(category)) {
      for (Category cat : Data.projects.keySet()) {
        if (cat.getId().equals(category.getId())) {
          cat.setName(category.getName());
        }
      }
    }
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
