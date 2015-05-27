package ua.goit.gojava32.kickstarter.model;

import javax.persistence.*;


@Entity
@Table (name = "categories")
public class Category {

  private static final int MAX_SHORT_NAME_LENGTH = 15;
  private static final int MAX_SHORT_DESC_LENGTH = 15;
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



  public String getShortName() {
    String res = name;
    if(name.length() >= MAX_SHORT_NAME_LENGTH){
       res = name.substring(0, MAX_SHORT_NAME_LENGTH - 3) + "...";
    }
    return res;
  }

  public String getShortDescription() {
    String res = description;
    if(description.length() >= MAX_SHORT_DESC_LENGTH){
      res = description.substring(0, MAX_SHORT_DESC_LENGTH - 3) + "...";
    }
    return res;
  }
}