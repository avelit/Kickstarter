package ua.goit.gojava32.kickstarter.factory;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;

public class FactoryModel {

  public static Category createCategory(String name){
    return new Category(name);
  }

  public static Category createCategory(Integer id, String name, String description){
    return new Category(id, name, description);
  }

  public static Project createProject(String name,Category category){
    return new Project(name, category);
  }

  public static Project createProject(Integer id, String name, String description, Integer idcategory){
    Category category = (new CategoryServiceImpl()).get(idcategory);
    return new Project(id, name, category, description);
  }
}
