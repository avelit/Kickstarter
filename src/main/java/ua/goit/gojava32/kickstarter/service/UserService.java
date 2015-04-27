package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.User;

public interface UserService extends GenericCRUDService{
  User add();
  User findUserByToken(String token);
}
