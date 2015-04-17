package ua.goit.gojava32.kickstarter.data;

import java.util.List;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public interface CategoryDAO {
  Category add(Category category);
  Category update(Category category);
  List<Category> findAll();
  List<Project> findAllProjects(Category category);
  List<Project> findAllProjects(Integer id);
  Category delete(Category category);
  Category get(Integer id);
  Category get(String name);
}
