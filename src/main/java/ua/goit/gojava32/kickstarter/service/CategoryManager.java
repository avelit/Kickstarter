package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager implements CategoryService{

    private List<Category> categories = new ArrayList<Category>();

    @Override
    public Category add(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        for (int i = 0; i < categories.size(); i++){
            if (categories.get(i).getName().equals(category.getName())){
                categories.set(i, category);
            }
        }
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
}
