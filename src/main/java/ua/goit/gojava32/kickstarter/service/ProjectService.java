package ua.goit.gojava32.kickstarter.service;

import java.util.List;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectService extends GenericCRUDService<Project>{
  Project add(String name, String description, Category category);
  List<String> getComments(Project project);
  List<String> getBlogs(Project project);
  void addComment(String comment, Project project);
  void addBlog(String comment, Project project);

}
