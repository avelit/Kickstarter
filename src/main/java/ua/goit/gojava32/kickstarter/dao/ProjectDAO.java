package ua.goit.gojava32.kickstarter.dao;

import java.util.List;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectDAO extends GenericCRUDDAO<Project>{
  void add(Project project, Category category);
  List<String> getComments(Project project);
  List<String> getBlogs(Project project);
}
