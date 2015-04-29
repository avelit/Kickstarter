package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.dao.UserDAO;
import ua.goit.gojava32.kickstarter.dao.UserDAOImpl;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.User;

public class UserServiceImpl implements UserService{

  UserDAO userDAO = new UserDAOImpl();

  @Override
  public User add(String name, String email, String token, Boolean isActive) {
    User user = FactoryModel.createUser(name, email, token, isActive);
    userDAO.add(user);
    return userDAO.get(name);
  }

  @Override
  public void update(User user) {
    userDAO.update(user);
  }

  @Override
  public void delete(User user) {
    userDAO.delete(user);
  }

  @Override
  public User get(Integer id) {
    return userDAO.get(id);
  }

  @Override
  public User get(String name) {
    return userDAO.get(name);
  }

  @Override
  public User add(User val) {
    return userDAO.add(val);
  }

  public User findUserByToken(String token){
    return userDAO.findUserByToken(token);
  }

}
