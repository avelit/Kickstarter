package ua.goit.gojava32.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

  private String name;
  private List<Project> projects;
  private Integer id;
  private String description = "";

  public Category(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Category(Integer id, String name, String description) {
    this.name = name;
    this.id = id;
    this.description = description;
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

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  public void addProject(Project project) {
    this.projects.add(project);
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return " id=" + id + ",name=" + name + ",description=" + description;
  }

}
