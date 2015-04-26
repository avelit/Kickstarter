package ua.goit.gojava32.kickstarter.model;

public class User {
  private Integer id;
  private String name;
  private String token;
  private boolean isActive;

  public User(String name, String token, Boolean isActive) {
    this.name = name;
    this.token = token;
    this.isActive = isActive;
  }
  public User(Integer id, String name, String token, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.token = token;
    this.isActive = isActive;
  }
}
