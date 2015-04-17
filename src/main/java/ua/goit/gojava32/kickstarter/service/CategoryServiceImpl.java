package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.data.CategoryDAO;
import ua.goit.gojava32.kickstarter.data.CategoryDAOImpl;
import ua.goit.gojava32.kickstarter.data.Data;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService{

    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public void add(Category category) {
        categoryDAO.add(category);
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