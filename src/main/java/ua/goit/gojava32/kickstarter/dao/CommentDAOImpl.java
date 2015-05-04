package ua.goit.gojava32.kickstarter.dao;

import org.apache.log4j.Logger;
import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.model.Comment;

import java.sql.Connection;

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
  public Comment get(String name) {
    return null;
  }

  @Override
  public Comment add(Comment val) {
    Logger logger = Logger.getLogger(this.getClass());
    logger.debug("Add comment:" + val.getText() + " project=" + val.getProject());
    Connection con = ConnectionPool.getConnection();
    String query = String.format("INSERT INTO comments (id_project, comment) VALUES ('%s', '%s')",
            val.getProject().getId(), val.getText());
    AbstractDAO.executeAdd(con, query);
    ConnectionPool.releaseConnection(con);
    return val;
  }
}
