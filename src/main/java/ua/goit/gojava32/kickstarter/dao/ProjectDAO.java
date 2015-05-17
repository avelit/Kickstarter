package ua.goit.gojava32.kickstarter.dao;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectDAO extends GenericCRUDDAO<Project>{
  List<Project> findFrom(String searchRequest);
  String getVideo(Project project);
}
