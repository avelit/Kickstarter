package ua.goit.gojava32.kickstarter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.data.Data;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class CategoryDAOImpl implements CategoryDAO {

  @Override
  public void add(Category category) {

    if (!Data.projects.containsKey(category)) {
      Data.projects.put(category, new ArrayList<Project>());
    }
  }

  @Override
  public void update(Category category) {
    if (Data.projects.keySet().contains(category)) {
      for (Category cat : Data.projects.keySet()) {
        if (cat.getId().equals(category.getId())) { //!!!Check condition!!!
          cat.setName(category.getName());
        }
      }
    }
  }

  @Override
  public Set<Category> findAll() {
    return Data.projects.keySet();
  }

  @Override
  public List<Project> findAllProjects(Category category) {
    return Data.projects.get(category);
  }

  @Override
  public List<Project> findAllProjects(Integer id) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getId().equals(id)) {
        return cat.getProjects();
      }
    }
    return null;
  }

  @Override
  public void delete(Category category) {
    Data.projects.remove(category);
  }

  @Override
  public Category get(Integer id) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getId().equals(id)) {
        return cat;
      }
    }
    return null;
  }

  @Override
  public Category get(String name) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getName().equals(name)) {
        return cat;
      }
    }
    return null;
  }
}
