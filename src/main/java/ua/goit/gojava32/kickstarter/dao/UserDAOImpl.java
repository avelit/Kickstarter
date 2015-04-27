package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl implements UserDAO {

  @Override
  public void add(User user) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("INSERT INTO users (user,token,email) VALUES ('%s','%s','%s')",
            user.getName(), user.getToken(),user.getEmail());
    AbstractDAO.executeAdd(con, query);
    ConnectionPool.releaseConnection(con);
  }

  @Override
  public User findUserByToken(String token) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("SELECT * FROM users WHERE token='%s'", token);
    User user = createUser(con, query);
    return user;
  }

  @Override
  public void update(Object val) {

  }

  @Override
  public void delete(Object val) {

  }

  @Override
  public Object get(Integer id) {
    return null;
  }

  @Override
  public Object get(String name) {
    return null;
  }

  private User createUser(Connection con, String query) {
    User user = null;
    try {
      Statement statement = con.createStatement();
      ResultSet result = statement.executeQuery(query);
      while (result.next()) {
        Integer id  = result.getInt("id");
        String name = result.getString("user");
        String email = result.getString("email");
        String token = result.getString("token");
        Integer active = result.getInt("active");
        boolean isActive = ((active==1) ? true : false);
        FactoryModel.createUser(id, name, email, token, isActive);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }
}
