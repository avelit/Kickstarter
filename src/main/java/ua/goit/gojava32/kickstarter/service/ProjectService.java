package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.*;

import java.util.List;

public interface ProjectService extends GenericCRUDService<Project>{
  Project add(String name, String description, Category category);
  List<Project> findFrom(String searchRequest);

  List<Project> findAllProjectsByUser(User user);

  List<Comment> getProjectComments(Project project);
  List<BlogPost> getProjectBlogPosts(Project project);

  List<Project> findAll();
}
