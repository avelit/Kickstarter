package test;

import org.junit.Test;

import service.DataService;
import view.View;

public class IntegrationTest {
  @Test
  public void whenGivenMusic(){
    System.out.println((new View()).getCategoryHtml("music"));
    System.out.println((new View()).getCategoryHtml("musi"));
    System.out.println((new View()).getCategoryHtml(""));
    System.out.println((new DataService()).getListOfCategories());
  }
}
