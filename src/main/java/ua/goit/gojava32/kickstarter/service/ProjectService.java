package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectService {
  void add(Project project);
  void update(Project project);
  void delete(Project project);
  Project get(Integer id);
}
