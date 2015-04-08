package test;

import org.junit.Test;

import view.View;

public class IntegrationTest {
  @Test
  public void whenGivenMusic(){
    System.out.println((new View()).getHtml("music"));
    System.out.println((new View()).getHtml("musi"));
    System.out.println((new View()).getHtml(""));
  }
}
