package ua.goit.gojava32.kickstarter.data;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface CategoryDAO {
  void add(Category category);
  void update(Category category);
  Set<Category> findAll();
  List<Project> findAllProjects(Category category);
  List<Project> findAllProjects(Integer id);
  void delete(Category category);
  Category get(Integer id);
  Category get(String name);
}
