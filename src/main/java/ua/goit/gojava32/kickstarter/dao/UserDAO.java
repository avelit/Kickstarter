package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.GenericCRUDService;

public interface UserDAO extends GenericCRUDDAO<User>{
  User findUserByEmail(String email);
}
