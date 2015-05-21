package ua.goit.gojava32.kickstarter.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ua.goit.gojava32.kickstarter.factory.DBHelper;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class IntegrationTest {
  
  private CategoryService categoryService = new CategoryServiceImpl();
  private ProjectService projectService = new ProjectServiceImpl();
  private UserService userService = new UserServiceImpl();

  @Before
  public void createDB() {
    DBHelper dbHelper = new DBHelper();
    dbHelper.initDatabase();
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

  @Ignore
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

  @Ignore
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

  @Ignore
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
