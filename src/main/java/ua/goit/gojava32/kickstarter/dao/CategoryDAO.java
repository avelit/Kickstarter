package ua.goit.gojava32.kickstarter.dao;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface CategoryDAO extends GenericCRUDDAO<Category>{
  List<Category> findAll();
  List<Project> findAllProjects(Category category);
  public List<Category> findFrom(String requestSearch);
}
