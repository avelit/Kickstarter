package ua.goit.gojava32.kickstarter.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
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
public class ProjectDAOImpl extends AbstractDAO<Project> implements ProjectDAO {

  @Override
  public List<String> getComments(Project project) {
    return getList("comments", project);
  }

  @Override
  public List<String> getBlogs(Project project) {
    return getList("blogs", project);
  }

  private List<String> getList(String table, Project project) {
    Session session = getSession();
    Query query = session.createQuery("SELECT comment FROM " + table + " WHERE id_project = " + project.getId());
    List<String> comments = query.list();
    return comments;
  }

  @Override
  public void addComment(String comment, Project project) {
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
    //AbstractDAO.executeAdd(con, query);
    ConnectionPool.releaseConnection(con);
  }

}