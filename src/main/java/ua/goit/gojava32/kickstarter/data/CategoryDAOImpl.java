package ua.goit.gojava32.kickstarter.data;

import java.util.List;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class CategoryDAOImpl implements CategoryDAO {

  @Override
  public Category add(Category category) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Category update(Category category) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Category> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Project> findAllProjects(Category category) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Project> findAllProjects(Integer id) {
    for (Category cat : categories) {
      if (cat.getId() == id) {
          return cat.getProjects();
      }
  }
  return null;
   // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Category delete(Category category) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Category get(Integer id) {
    for (Category cat : categories) {
      if (cat.getId() == id){
          return cat;
      }
  }
  return null;
    return null;
  }

  @Override
  public Category get(String name) {
    for (Category cat : categories) {
      if (cat.getName() == name){
          return cat;
      }
  }
    return null;
  }
} }

}
