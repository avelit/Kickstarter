package ua.goit.gojava32.kickstarter.model;

public class Project {
  private Integer id;
  private String name;
  private String description = "";
  private Category category;

  public Project (String name, Category category, String description){
    this.name = name;
    this.category = category;
    this.description = description;
  }

  public Project (Integer id, String name, Category category){
    this(name, category, "");
    this.id = id;
  }

  public Project(Integer id, String name, Category category, String description) {
    this(id, name, category);
    this.description = description;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public Category getCategory () {
    return category;
  }

  public Integer getId () {
    return id;
  }

  public void setCategory (Category category) {
    this.category = category;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public String getDescription(){
    return description;
  }

  @Override
  public String toString() {
    return "id=" + id + ",name=" + name + ",description=" + description + ", category=" + category.getName() ;
  }

}
