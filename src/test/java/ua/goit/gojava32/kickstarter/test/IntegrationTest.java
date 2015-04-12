package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;

import ua.goit.gojava32.kickstarter.service.DataProvider;
import ua.goit.gojava32.kickstarter.view.HtmlGenerator;

public class IntegrationTest {
  @Test
  public void whenGivenMusic(){
    System.out.println(HtmlGenerator.getHtml("music"));
    System.out.println(HtmlGenerator.getHtml("categories"));
    System.out.println(HtmlGenerator.getCategoryHtml(""));
    System.out.println((new DataProvider()).getCategories());
  }
}
