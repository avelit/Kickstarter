package ua.goit.gojava32.kickstarter.model;

public class Category {

  private String name;
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

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return " id=" + id + ",name=" + name + ",description=" + description;
  }

}
