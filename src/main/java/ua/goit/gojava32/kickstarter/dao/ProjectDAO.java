package ua.goit.gojava32.kickstarter.dao;

import java.util.List;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.model.User;

public interface ProjectDAO extends GenericCRUDDAO<Project>{
  List<Project> findFrom(String searchRequest);
  List<Project> findAllProjects(User user);
}
