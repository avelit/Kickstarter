package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;

import ua.goit.gojava32.kickstarter.service.DataProvider;
import ua.goit.gojava32.kickstarter.controller.HtmlController;

public class IntegrationTest {
  @Test
  public void whenGivenMusic(){
    //System.out.println(HtmlController.getHtml("music"));
    //System.out.println(HtmlController.getHtml("categories"));
    //System.out.println(HtmlController.getCategoryHtml(""));
    System.out.println((new DataProvider()).getCategories());
  }
}
