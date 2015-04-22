package ua.goit.gojava32.kickstarter.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;

public class IntegrationTest {
  
  private CategoryService categoryService = new CategoryServiceImpl();
  private ProjectService projectService = new ProjectServiceImpl();

  @Test
  public void categoryCRUDadd(){
    Category category = categoryService.add("testCategoryAdd");
    assertEquals("testCategoryAdd", category.getName());
  }

  @Test
  public void projectCRUDadd(){
    Category category = categoryService.add("testProjectAdd");
    Project project = projectService.add("testProjectAdd", category);
    assertEquals("testProjectAdd", project.getName());
  }
  
}
