package factory;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class FactoryModel {

  public static Category createCategory(String name){
    return new Category(name);
  }

  public static Project createProject(String name,Category category){
    return new Project(name, category);
  }

}
