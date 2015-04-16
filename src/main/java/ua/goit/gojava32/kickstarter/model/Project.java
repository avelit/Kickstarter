package ua.goit.gojava32.kickstarter.model;

import java.util.List;

public class Project {
  private String name;
  private Category category;
  private List<String> comment;
  private Integer id;

  public String getName(){
    return name;
  }

  public Category getCategory () {
    return category;
  }

  public List<String> getComment () {
    return comment;
  }

  public Integer getId () {
    return id;
  }
}
