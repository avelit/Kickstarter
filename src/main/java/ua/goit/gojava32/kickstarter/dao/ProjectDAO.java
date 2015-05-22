package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.model.User;

import java.util.List;

public interface ProjectDAO extends GenericCRUDDAO<Project>{
  List<Project> findFrom(String searchRequest);
  List<Project> findAllProjectsByUser(User user);

  List<Project> findAll();
}
