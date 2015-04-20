package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;

import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;

public class IntegrationTest {
  @Test
  public void whenLookingProject(){
    Project result = new ProjectServiceImpl().get("heart");
    result.addComment("sdgsd");
    System.out.println(result.getComment());
  }
}
