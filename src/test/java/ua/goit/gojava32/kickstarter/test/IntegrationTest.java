package ua.goit.gojava32.kickstarter.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import ua.goit.gojava32.kickstarter.factory.FactoryDB;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;

public class IntegrationTest {
  
  private CategoryService categoryService = new CategoryServiceImpl();
  private ProjectService projectService = new ProjectServiceImpl();

//  @Ignore
  @Test
  public void categoryCRUD(){

    FactoryDB.createDB();
    
    String name = "testCategoryAdd";
    String nameChanged = "testCategoryAddChanged";
    String description = "test description";

    Set<Category> allCategiries = categoryService.findAll();
    
    System.out.println(Arrays.deepToString(allCategiries.toArray()));
    
    Category category = categoryService.add(name, description);
    assertEquals(name, category.getName());
    
    category.setName(nameChanged);
    categoryService.update(category);
    assertNull(categoryService.get(name));
    assertEquals(nameChanged, categoryService.get(nameChanged).getName());
    
    categoryService.delete(category);
    assertNull(categoryService.get(nameChanged));
  }

//  @Ignore
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
  
}
