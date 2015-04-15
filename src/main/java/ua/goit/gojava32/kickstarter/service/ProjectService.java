package ua.goit.gojava32.kickstarter.service;

import java.util.List;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectService {
  Project add(Project project);
  Project update(Project project);
  List<Project> findAll(Category category);
  List<Project> findAll(Integer id);//id category
  Project delete(Project project);
  Project get(Integer id);
}
