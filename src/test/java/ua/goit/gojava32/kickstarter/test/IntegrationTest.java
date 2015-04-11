package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;

import ua.goit.gojava32.kickstarter.service.DataService;
import ua.goit.gojava32.kickstarter.view.View;

public class IntegrationTest {
  @Test
  public void whenGivenMusic(){
    System.out.println((new View()).getHtml("music"));
    System.out.println((new View()).getHtml("categories"));
    System.out.println((new View()).getCategoryHtml(""));
    System.out.println((new DataService()).getCategories());
  }
}
