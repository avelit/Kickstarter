package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.data.Data;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectDAOImpl implements ProjectDAO {

  @Override
  public void add(Project project,Category category) {
    Connection con = ConnectionPool.getConnection();
    String queryCheck = String.format("SELECT * FROM projects WHERE category_id = '%d', name = '%s'", category.getId(), project.getName());
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

  }

  @Override
  public void delete(Project project) {
    Data.projects.values().remove(project);
  }

  @Override
  public Project get(Integer id) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getProjects() != null) {
        for (Project project : cat.getProjects()) {
          if (project.getId().equals(id)) {
            return project;
          }
        }
      }
    }
    return null;
  }

  @Override
  public Project get(String name) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getProjects() != null) {
        for (Project project : cat.getProjects()) {
          if (project.getName().equals(name)) {
            return project;
          }
        }
      }
    }
    return null;
  }
}