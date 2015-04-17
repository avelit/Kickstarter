package ua.goit.gojava32.kickstarter.model;

import java.util.List;

public class Category {
  private String name;
  private List<Project> projects;
  private Integer id;

  public Category(Integer id, String name){
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Project> getProjects () {
    return projects;
  }
}
