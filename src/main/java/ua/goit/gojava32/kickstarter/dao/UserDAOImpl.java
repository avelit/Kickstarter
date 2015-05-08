package ua.goit.gojava32.kickstarter.dao;

import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Repository
public class UserDAOImpl implements UserDAO {

  @Override
  public User add(User user) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("INSERT INTO users (name,token,email) VALUES ('%s','%s','%s')",
            user.getName(), user.getToken(),user.getEmail());
    AbstractDAO.executeAdd(con, query);
    ConnectionPool.releaseConnection(con);
    return user;
  }

  @Override
  public User findUserByToken(String token) {
    String query = String.format("SELECT * FROM users WHERE token='%s'", token);
    return getUser(query);
  }

  @Override
  public User findUserByEmail(String email) {
    String query = String.format("SELECT * FROM users WHERE email='%s'", email);
    return getUser(query);
  }

  @Override
  public void update(User user) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("UPDATE users SET name = '%s', active = '%d' WHERE id = '%d'",
            user.getName(), user.isActive()?1:0, user.getId());
    AbstractDAO.executeUpdate(con, query);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public void delete(User user) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("DELETE FROM users WHERE id = '%d'", user.getId());
    AbstractDAO.executeUpdate(con, query);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public User get(Integer id) {
    String query = String.format("SELECT * FROM users WHERE id='%s'", id);
    return getUser(query);
  }


  private User getUser(String query) {
    Connection con = ConnectionPool.getConnection();
    User user = null;
    try {
      Statement statement = con.createStatement();
      ResultSet result = statement.executeQuery(query);
      while (result.next()) {
        Integer id  = result.getInt("id");
        String name = result.getString("name");
        String email = result.getString("email");
        String token = result.getString("token");
        Integer active = result.getInt("active");
        boolean isActive = ((active == 1));
        user = FactoryModel.createUser(id, name, email, token, isActive);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    ConnectionPool.releaseConnection(con);
    return user;
  }
}
