package ua.goit.gojava32.kickstarter.service;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface CategoryService extends GenericCRUDService<Category>{
  Category add(String name, String description);
  Set<Category> findAll();
  List<Project> findAllProjects(Category category);
  List<Project> findAllProjects(Integer id);
  public Set<Category> findFrom(String requestSearch);
}
