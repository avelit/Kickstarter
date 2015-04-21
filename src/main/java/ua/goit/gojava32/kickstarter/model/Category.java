package ua.goit.gojava32.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

  private String name;
  private List<Project> projects;
  private Integer id;
  public String description;

  public Category(Integer id, String name){
    this.id = id;
    this.name = name;
    this.projects = new ArrayList<Project>();
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

  public void setProjects (List<Project> projects) {
    this.projects = projects;
  }

  public void addProject (Project project) {
    this.projects.add(project);
  }

  public void setDescription(String description){
    this.description = description;
  }

  public String getDescription(){
    return description;
  }

  @Override
  public String toString() {
    return "Category [name=" + name + "]";
  }

}
