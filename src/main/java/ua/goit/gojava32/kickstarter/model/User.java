package ua.goit.gojava32.kickstarter.model;

public class User {
  private Integer id;
  private String name;
  private String token;
  private String email;
  private boolean isActive;

  public User(String name, String email, String token, Boolean isActive) {
    this.name = name;
    this.token = token;
    this.email = email;
    this.isActive = isActive;
  }
  public User(Integer id, String name, String email, String token, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.token = token;
    this.email = email;
    this.isActive = isActive;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getToken() {
    return token;
  }

  public String getEmail() {
    return email;
  }

  public boolean isActive() {
    return isActive;
  }

}
