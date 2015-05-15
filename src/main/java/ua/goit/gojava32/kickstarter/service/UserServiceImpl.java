package ua.goit.gojava32.kickstarter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.dao.UserDAO;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.User;
@Transactional
@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserDAO userDAO;

  @Override
  public User add(String name, String email, String token, Boolean isActive) {
    User user = FactoryModel.createUser(name, email, token, isActive);
    return userDAO.add(user);
  }

  @Override
  public User getUser(String name) {
    User user = new User("test", "test@test.ru", "123", true);
    return user;
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
  public User add(User val) {
    return userDAO.add(val);
  }

  public User findUserByToken(String token){
    return userDAO.findUserByToken(token);
  }

  public User findUserByEmail(String email){
    return userDAO.findUserByEmail(email);
  }
}
