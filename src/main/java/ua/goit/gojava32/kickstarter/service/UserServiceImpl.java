package ua.goit.gojava32.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.dao.UserDAO;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.model.User;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDAO userDAO;

  @Override
  public User add(String name, String email, String password, Boolean isActive) {
    User user = FactoryModel.createUser(name, email, password, isActive);
    return userDAO.add(user);
  }

  @Override
  public User update(User user) {
    return userDAO.update(user);
  }

  @Override
  public User delete(User user) {
    return userDAO.delete(user);
  }

  @Override
  public User get(Integer id) {
    return userDAO.get(id);
  }

  @Override
  public User add(User val) {
    return userDAO.add(val);
  }

  @Override
  public User findUserByEmail(String email){
    return userDAO.findUserByEmail(email);
  }

}
