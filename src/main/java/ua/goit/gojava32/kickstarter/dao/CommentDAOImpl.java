package ua.goit.gojava32.kickstarter.dao;

import org.apache.log4j.Logger;
import sun.util.logging.resources.logging;
import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.sql.*;
import java.text.SimpleDateFormat;
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
    String query = String.format("INSERT INTO comments (id_project, comment, created) VALUES (?, ?, ?)");


    PreparedStatement pstmt = null;
    try {
      pstmt = con.prepareStatement(query);
      pstmt.setInt(1, val.getProject().getId());
      pstmt.setString(2,val.getComment());

      java.sql.Date sqlDate = new java.sql.Date(val.getCreated().getTime());
      pstmt.setDate(3,sqlDate);
      int affectedRows = pstmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("Creating user failed, no rows affected.");
      }
      try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          val.setId(generatedKeys.getInt(1));
        }
        else {
          throw new SQLException("Creating user failed, no ID obtained.");
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

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
