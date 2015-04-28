package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.dao.CategoryDAO;
import ua.goit.gojava32.kickstarter.dao.CategoryDAOImpl;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

  private CategoryDAO categoryDAO = new CategoryDAOImpl();

  @Override
  public Category add(String name, String description) {
    Category category = FactoryModel.createCategory(name, description);
    categoryDAO.add(category);
    return categoryDAO.get(name);
  }

  @Override
  public void update(Category category) {
    categoryDAO.update(category);
  }

  @Override
  public Set<Category> findAll() {
    return categoryDAO.findAll();
  }

  @Override
  public List<Project> findAllProjects(Category category) {
    return categoryDAO.findAllProjects(category);
  }

  @Override
  public List<Project> findAllProjects(Integer id) {
    return categoryDAO.findAllProjects(id);
  }

  @Override
  public void delete(Category category) {
    categoryDAO.delete(category);
  }

  @Override
  public Category get(Integer id) {
    return categoryDAO.get(id);
  }

  @Override
  public Category get(String name) {
    return categoryDAO.get(name);
  }

}