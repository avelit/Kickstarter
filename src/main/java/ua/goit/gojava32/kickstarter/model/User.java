package ua.goit.gojava32.kickstarter.model;

public class User {
  private Integer id;
  private String name;
  private String pass;
  private String email;
  private String token;
  private boolean isActive;

  public User(String name, String email, String pass, Boolean isActive) {
    this.name = name;
    this.pass = pass;
    this.email = email;
    this.isActive = isActive;
  }
  public User(Integer id, String name, String email, String pass, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.pass = pass;
    this.email = email;
    this.isActive = isActive;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPass() {
    return pass;
  }

  public String getEmail() {
    return email;
  }

  public boolean isActive() {
    return isActive;
  }

}
