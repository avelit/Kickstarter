package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.model.User;

import java.sql.Connection;

public class UserDAOImpl implements UserDAO {

  @Override
  public void add(User user) {
    Connection con = ConnectionPool.getConnection();
    String query = String.format("INSERT INTO users (name,token) VALUES ('%s', '%s')", user.getName(), user.getToken());


  }

  @Override
  public User findUserByToken(String token) {
    Connection con = ConnectionPool.getConnection();

    return new User("QQQ","fff","fff",true);
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
}
