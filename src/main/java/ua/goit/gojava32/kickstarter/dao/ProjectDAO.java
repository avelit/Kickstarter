package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectDAO {
  void add(Project project, Category category);
  void update(Project project);
  void delete(Integer id);
  void delete(Project project);
    Project get(Integer id);
  Project get(String name);
}
