package ua.goit.gojava32.kickstarter.dao;

import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CommentDAOImpl extends AbstractDAO<Comment> implements CommentDAO{

  public Comment add(Comment val) {

    Connection con = ConnectionPool.getConnection();
    String query = String.format("INSERT INTO comments (id_project, text, created) VALUES (?, ?, ?)");

    PreparedStatement pstmt = null;
    try {
      pstmt = con.prepareStatement(query);
      pstmt.setInt(1, val.getProject().getId());
      pstmt.setString(2,val.getText());

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
        comment.setText(rs.getString("text"));
        comments.add(comment);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
    return comments;
  }

}
