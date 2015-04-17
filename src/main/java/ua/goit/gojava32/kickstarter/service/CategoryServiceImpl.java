package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.data.CategoruDAOImpl;
import ua.goit.gojava32.kickstarter.data.CategoryDAO;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    private CategoryDAO categories = new CategoruDAOImpl();

    @Override
    public Category add(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        return category;
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public List<Project> findAllProjects(Category category) {
        return category.getProjects();
    }

    @Override
    public List<Project> findAllProjects(Integer id) {
        for (Category cat : categories) {
            if (cat.getId() == id) {
                return cat.getProjects();
            }
        }
        return null;
    }

    @Override
    public Category delete(Category category) {
        categories.remove(category);
        return category;
    }

    @Override
    public Category get(Integer id) {
        for (Category cat : categories) {
            if (cat.getId() == id){
                return cat;
            }
        }
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
}
