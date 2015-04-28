package ua.goit.gojava32.kickstarter.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ua.goit.gojava32.kickstarter.factory.FactoryDB;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.*;

public class IntegrationTest {
  
  private CategoryService categoryService = new CategoryServiceImpl();
  private ProjectService projectService = new ProjectServiceImpl();
  private UserService userService = new UserServiceImpl();

  @Before
  public void createDB() {
    FactoryDB.createDB();
  }
  
  @Test
  public void categoryCRUD(){

    String name = "testCategoryAdd";
    String nameChanged = "testCategoryAddChanged";
    String description = "test description";

    Set<Category> allCategiries = categoryService.findAll();
    
    Category category = categoryService.add(name, description);
    assertEquals(name, category.getName());
    
    category.setName(nameChanged);
    categoryService.update(category);
    assertNull(categoryService.get(name));
    assertEquals(nameChanged, categoryService.get(nameChanged).getName());
    
    categoryService.delete(category);
    assertNull(categoryService.get(nameChanged));
  }

  @Test
  public void projectCRUD(){
    
    String name = "testProjectAdd";
    String nameChanged = "testProjectAddChanged";
    String description = "test description";

    Category category = categoryService.add(name, description);
    
    Project project = projectService.add(name,description,category);
    assertEquals(name, project.getName());
    
    project.setName(nameChanged);
    projectService.update(project);
    assertNull(projectService.get(name));
    assertEquals(nameChanged, projectService.get(nameChanged).getName());
    
    projectService.delete(project);
    assertNull(projectService.get(nameChanged));
    
    categoryService.delete(category);
  }

  @Test
  public void userCRUD() {
    String name = "test";
    String email = "test@test.com";
    String token = "123321";

    User user = userService.add(name, email, token, true);
    assertEquals(name, user.getName());

    userService.delete(user);
    assertNull(userService.get(user.getId()));
  }


}
