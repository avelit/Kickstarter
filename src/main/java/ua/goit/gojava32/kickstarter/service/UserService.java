package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.User;

public interface UserService extends GenericCRUDService<User>{
  User add(String name, String email, String token, Boolean isActive);
  User findUserByEmail(String email);
}
