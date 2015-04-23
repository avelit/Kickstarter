package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectService {
  void add(Project project, Category category);
  Project add(String name, String description, Category category);
  void update(Project project);
  void delete(Project project);
  Project get(Integer id);
  Project get(String name);
}
