package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.BlogPost;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;

public interface ProjectService extends GenericCRUDService<Project>{
  Project add(String name, String description, Category category);
  List<Project> findFrom(String searchRequest);

  List<Comment> getProjectComments(Project project);
  List<BlogPost> getProjectBlogPosts(Project project);
}
