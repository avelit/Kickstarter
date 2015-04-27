package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.dao.UserDAO;
import ua.goit.gojava32.kickstarter.dao.UserDAOImpl;
import ua.goit.gojava32.kickstarter.model.User;

public class UserServiceImpl implements UserService{

  UserDAO userDAO = new UserDAOImpl();
  @Override
  public User add() {
    return null;
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

  public User findUserByToken(String token){
    return userDAO.findUserByToken(token);
  }
}
