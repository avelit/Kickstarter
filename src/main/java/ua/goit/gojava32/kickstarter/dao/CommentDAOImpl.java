package ua.goit.gojava32.kickstarter.dao;

import org.apache.log4j.Logger;
import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO{
  @Override
  public void update(Comment val) {

  }

  @Override
  public void delete(Integer id) {

  }

  @Override
  public void delete(Comment val) {

  }

  @Override
  public Comment get(Integer id) {
    return null;
  }


  @Override
  public Comment add(Comment val) {

    Connection con = ConnectionPool.getConnection();
    String query = String.format("INSERT INTO comments (id_project, comment) VALUES ('%s', '%s')",
            val.getProject().getId(), val.getComment());
    AbstractDAO.executeAdd(con, query);
    ConnectionPool.releaseConnection(con);
    return val;
  }

  @Override
  public List<Comment> getByProject(Project project) {


    List<Comment> comments = new ArrayList<>();
    Comment comment;
    Connection con = ConnectionPool.getConnection();
    String query = String.format("SELECT * FROM comments WHERE id_project = '%s'", project.getId());
    try (Statement st = con.createStatement()) {
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {
        rs.getString("author");

        comment = new Comment();
        comment.setCreated(rs.getDate("created"));
        comment.setId(rs.getInt("id"));
        comment.setProject(project);
        comment.setComment(rs.getString("comment"));
        comments.add(comment);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
    return comments;
  }

}
