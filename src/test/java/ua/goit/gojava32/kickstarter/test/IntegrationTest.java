package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;

import ua.goit.gojava32.kickstarter.model.Project;
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
    Project project = new Project(5, "project_name");
    project.setCategory((new CategoryServiceImpl()).get("music"));
    (new ProjectServiceImpl()).add(project);
    System.out.println(project);
  }
}
