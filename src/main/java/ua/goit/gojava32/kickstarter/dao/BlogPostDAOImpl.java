package ua.goit.gojava32.kickstarter.dao;

import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.model.BlogPost;
import ua.goit.gojava32.kickstarter.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogPostDAOImpl implements BlogPostDAO{

  @Override
  public List<BlogPost> getByProject(Project project) {
    List<BlogPost> blogPosts = new ArrayList<>();
    BlogPost blogPost;
    Connection con = ConnectionPool.getConnection();
    String query = String.format("SELECT * FROM blogs WHERE id_project = '%s'", project.getId());
    try (Statement st = con.createStatement()) {
      ResultSet rs = st.executeQuery(query);
      while (rs.next()) {

        rs.getString("author");

        blogPost = new BlogPost();
        blogPost.setCreated(rs.getDate("created"));
        blogPost.setId(rs.getInt("id"));
        blogPost.setProject(project);
        blogPost.setText(rs.getString("text"));
        blogPosts.add(blogPost);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ConnectionPool.releaseConnection(con);
    return blogPosts;
  }


  @Override
  public BlogPost update(BlogPost val) {
    return null;
  }

  @Override
  public BlogPost delete(Integer id) {
    return null;
  }

  @Override
  public BlogPost delete(BlogPost val) {
    return null;
  }

  @Override
  public BlogPost get(Integer id) {
    return null;
  }

  @Override
  public BlogPost add(BlogPost val) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("INSERT INTO blogs (id_project, text, created) VALUES (?, ?, ?)");


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
}
