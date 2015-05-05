package ua.goit.gojava32.kickstarter.dao;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectDAO extends GenericCRUDDAO<Project>{
  List<String> getComments(Project project);
  List<String> getBlogs(Project project);
  void addComment(String comment, Project project);
  void addBlog(String comment, Project project);
  Set<Project> findFrom(String searchRequest);
}
