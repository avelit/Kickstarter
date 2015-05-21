package ua.goit.gojava32.kickstarter.factory;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Image;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;

public class FactoryModel {

  public static Category createCategory(String name, String description){
    return new Category(name, description);
  }

  public static Category createCategory(Integer id, String name, String description){
    return new Category(id, name, description);
  }

  public static Project createProject(String name,Category category, String description){
    return new Project(name, category, description);
  }

  public static Project createProject(Integer id, String name, String description, Integer idCategory){
    Category category = (new CategoryServiceImpl()).get(idCategory);
    return new Project(id, name, category, description);
  }

  public static User createUser(String name, String token, String email, Boolean isActive){
    return new User(name, email, token, isActive);
  }

  public static User createUser(Integer id, String name, String email, String token, Boolean isActive){
    return new User(id, name, email, token, isActive);
  }

  public static Image createImage(Integer id, Project project, byte[] picture) {
    return new Image(id, project, picture);
  }
}
