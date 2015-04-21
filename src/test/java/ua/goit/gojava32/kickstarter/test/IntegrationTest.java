package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;

public class IntegrationTest {
  @Test
  public void whenLookingProject(){
    Project result = new ProjectServiceImpl().get("heart");
    result.addComment("sdgsd");
    System.out.println(result.getComment());
  }
  
  
  @Test
  public void whenAddProject(){
    CategoryService categoryService = new CategoryServiceImpl();
    Project project = new Project(5, "project_name");
    Category category = new Category(5, "category_name");
    categoryService.add(category);
    project.setCategory(categoryService.get("category_name"));
    (new ProjectServiceImpl()).add(project);
    System.out.println(project);
    project = (new ProjectServiceImpl()).get("project_name");
    System.out.println(project);
  }
}
