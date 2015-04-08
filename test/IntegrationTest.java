package test;

import org.junit.Test;

import view.View;

public class IntegrationTest {
  @Test
  public void whenGivenMusic(){
    System.out.println((new View()).getHtml("music"));
  }
}
