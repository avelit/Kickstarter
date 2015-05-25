package ua.goit.gojava32.kickstarter.model;

import javax.persistence.*;


@Entity
@Table (name = "categories")
public class Category {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Integer id;

  private String name;
  private String description = "";

  public Category() {
  }

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
