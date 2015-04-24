package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

  @Override
  public void add(Project project, Category category) {
    Connection con = ConnectionPool.getConnection();
    String queryCheck = String.format("SELECT * FROM projects WHERE id_category = '%d' AND name = '%s'", category.getId(), project.getName());
    String query = String.format("INSERT INTO projects (name, id_category, description) VALUES ('%s', '%d', '%s')",
            project.getName(), category.getId(), project.getDescription());
    AbstractDAO.executeAdd(con, query, queryCheck);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public void update(Project project) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("UPDATE projects SET name = '%s', description = '%s' WHERE id = '%d'",
            project.getName(), project.getDescription(), project.getId());
    AbstractDAO.executeUpdate(con, query);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public void delete(Integer id) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("DELETE FROM projects WHERE id = '%d'", id);
    AbstractDAO.executeUpdate(con, query);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public void delete(Project project) {
    delete(project.getId());
  }

  @Override
  public Project get(Integer id) {
    String query = String.format("SELECT * FROM projects WHERE id = '%d'", id);
    Project project = getProject(query);
    return project;
  }

  @Override
  public Project get(String name) {
    String query = String.format("SELECT * FROM projects WHERE name = '%s'", name);
    Project project = getProject(query);
    return project;
  }

  private Project getProject(String query) {
    Connection con = ConnectionPool.getConnection();
    Project project = null;
    try (Statement st = con.createStatement()) {
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {
        Integer id = rs.getInt("id");
        String description = rs.getString("description");
        String name = rs.getString("name");
        Integer categoryID = rs.getInt("id_category");
        project = FactoryModel.createProject(id, name, description, categoryID);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
    return project;
  }

  @Override
  public List<String> getComments(Project project) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<String> getBlogs(Project project) {
    // TODO Auto-generated method stub
    return null;
  }
}