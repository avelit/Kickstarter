package ua.goit.gojava32.kickstarter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table (name = "projects")
public class Project {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "id_author", nullable = false)
  @JsonIgnore
  private User user;

  private String description = "";

  @ManyToOne (fetch = FetchType.EAGER)
  @JoinColumn (name = "id_category", nullable = false)
  private Category category;

  private Integer moneyNeed;
  private Integer moneyHas;
  private String video;

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

  public Project() {

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

  public int getMoneyNeed() {
    return moneyNeed;
  }

  public void setMoneyNeed(int moneyNeed) {
    this.moneyNeed = moneyNeed;
  }

  public int getMoneyHas() {
    return moneyHas;
  }

  public void setMoneyHas(int moneyHas) {
    this.moneyHas = moneyHas;
  }

  public String getVideo() {
    return video;
  }

  public void setVideo(String video) {
    this.video = video;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setMoneyNeed(Integer moneyNeed) {
    this.moneyNeed = moneyNeed;
  }

  public void setMoneyHas(Integer moneyHas) {
    this.moneyHas = moneyHas;
  }
}
