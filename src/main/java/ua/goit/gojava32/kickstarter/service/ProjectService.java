package ua.goit.gojava32.kickstarter.service;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.model.BlogPost;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectService extends GenericCRUDService<Project>{
  Project add(String name, String description, Category category);
  Set<Project> findFrom(String searchRequest);

  List<Comment> getProjectComments(Project project);
  List<BlogPost> getProjectBlogPosts(Project project);

}
