package ua.goit.gojava32.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.dao.CategoryDAO;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;
@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryDAO categoryDAO;

  @Override
  public Category add(String name, String description) {
    Category category = FactoryModel.createCategory(name, description);
    category = categoryDAO.add(category);
    return category;
  }
  @Override
  public Category add(Category category) {
    return categoryDAO.add(category);
  }

  @Override
  public Category update(Category category) {
    categoryDAO.update(category);
    return category;
  }

  @Override
  public List<Category> findAll() {
    return categoryDAO.findAll();
  }

  @Override
  public List<Project> findAllProjects(Category category) {
    return categoryDAO.findAllProjects(category);
  }

  @Override
  public List<Category> findFrom(String requestSearch) {
    return categoryDAO.findFrom(requestSearch);
  }

  @Override
  public List<Project> findAllProjects(Integer id) {
    return categoryDAO.findAllProjects(categoryDAO.get(id));
  }

  @Override
  public Category delete(Category category) {
    categoryDAO.delete(category);
    return category;
  }

  @Override
  public Category get(Integer id) {
    return categoryDAO.get(id);
  }
}