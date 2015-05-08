package ua.goit.gojava32.kickstarter.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
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

@Repository
public class ProjectDAOImpl implements ProjectDAO {

  @Override

  public Project add(Project project) {
    Category category = project.getCategory();
    Connection con = ConnectionPool.getConnection();
    String queryCheck = String.format("SELECT * FROM projects WHERE id_category = '%d' AND name = '%s'", category.getId(), project.getName());
    String query = String.format("INSERT INTO projects (name, id_category, description) VALUES ('%s', '%d', '%s')",
            project.getName(), category.getId(), project.getDescription());
    AbstractDAO.executeAdd(con, query, queryCheck);
    ConnectionPool.releaseConnection(con);
    return project;
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
    return getList("comments", project);
  }

  @Override
  public List<String> getBlogs(Project project) {
    return getList("blogs", project);
  }

  private List<String> getList(String table, Project project) {
    List<String> comments = new ArrayList<>();
    Connection con = ConnectionPool.getConnection();
    String query = String.format("SELECT * FROM " + table + " WHERE id_project = '%s'", project.getId());
    try (Statement st = con.createStatement()) {
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {
        String author = rs.getString("author");
        String comment = rs.getString("comment");
        comments.add(comment);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
    return comments;
  }

  @Override
  public void addComment(String comment,Project project) {
    addToList(comment, "comments", project);
  }

  @Override
  public void addBlog(String comment,Project project) {
    addToList(comment, "blogs", project);
  }

  @Override
  public Set<Project> findFrom(String requestSearch) {
    Connection con = ConnectionPool.getConnection();
    Set<Project> resultSearch = new HashSet<>();
    try (Statement st = con.createStatement()) {
      String query = String.format("SELECT * FROM projects WHERE name LIKE '%s'", "%"+requestSearch+"%");
      ResultSet result = st.executeQuery(query);
      while (result.next()) {
        Integer id = result.getInt("id");
        String name = result.getString("name");
        String description = result.getString("description");
        Integer categoryID = result.getInt("id_category");
        resultSearch.add(FactoryModel.createProject(id, name, description,categoryID));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
    return resultSearch;
  }

  private void addToList(String comment, String table, Project project) {
    Logger logger = Logger.getLogger(this.getClass());
    logger.debug("Add comment:" + comment + " project=" + project);
    Connection con = ConnectionPool.getConnection();
    String query = String.format("INSERT INTO " + table + " (id_project, comment) VALUES ('%s', '%s')",
            project.getId(), comment);
    AbstractDAO.executeAdd(con, query);
    ConnectionPool.releaseConnection(con);
  }

}