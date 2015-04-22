package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.dao.CategoryDAO;
import ua.goit.gojava32.kickstarter.dao.CategoryDAOImpl;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;
import java.util.Set;

import factory.FactoryModel;

public class CategoryServiceImpl implements CategoryService{

    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Override
    public Category add(String name) {
      Category category = FactoryModel.createCategory(name);
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