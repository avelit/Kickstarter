package ua.goit.gojava32.kickstarter.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import factory.FactoryDB;
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
  public void categoryCRUD(){
    String name = "testCategoryAdd";
    String nameChanged = "testCategoryAddChanged";
    
    Category category = categoryService.add(name);
    assertEquals(name, category.getName());
    
    category.setName(nameChanged);
    assertNull(categoryService.get(name));
    assertSame(nameChanged, categoryService.get(nameChanged).getName());
    
    categoryService.delete(category);
    assertNull(categoryService.get(nameChanged));
  }

  @Ignore
  @Test
  public void projectCRUD(){
    
    FactoryDB.createDB();
    
    String name = "testProjectAdd";
    String nameChanged = "testProjectAddChanged";

    Category category = categoryService.add(name);
    
    Project project = projectService.add(name,category);
    assertEquals(name, project.getName());
    
    project.setName(nameChanged);
    assertNull(projectService.get(name));
    assertSame(nameChanged, projectService.get(nameChanged).getName());
    
    projectService.delete(project);
    assertNull(projectService.get(nameChanged));
    
    categoryService.delete(category);
  }
  
}
