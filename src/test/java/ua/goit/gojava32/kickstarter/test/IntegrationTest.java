package ua.goit.gojava32.kickstarter.test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;

import ua.goit.gojava32.kickstarter.factory.FactoryDB;
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
  public void check_add_service_with_any_argument() {
    Category category = new Category("test","test");
    CategoryService categoryServiceMock = mock(CategoryServiceImpl.class);
    when(categoryServiceMock.add(anyString(), anyString())).thenReturn(category);
    categoryServiceMock.add("test","test");
    verify(categoryServiceMock).add(anyString(), anyString());
    assertEquals(category.getName(), "test");
  }

  @Test
  public void categoryCRUD() {

    String name = "testCategoryAdd";
    String nameChanged = "testCategoryAddChanged";
    String description = "test description";

    Category category = categoryService.add(name, description);
    assertEquals(name, category.getName());

    category.setName(nameChanged);
    categoryService.update(category);

//    assertEquals(nameChanged, categoryService.get(category.getId()).getName());

    categoryService.delete(category);
    assertNull(categoryService.get(category.getId()));
  }

  @Test
  public void projectCRUD() {

    String name = "testProjectAdd";
    String nameChanged = "testProjectAddChanged";
    String description = "test description";

    Category category = categoryService.add(name, description);

    Project project = projectService.add(name,description,category);
    assertEquals(name, project.getName());

    project.setName(nameChanged);
    projectService.update(project);

//    assertEquals(nameChanged, projectService.get(project.getId()).getName());

    projectService.delete(project);
    assertNull(projectService.get(project.getId()));

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
