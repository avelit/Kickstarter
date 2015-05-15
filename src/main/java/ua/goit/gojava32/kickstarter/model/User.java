package ua.goit.gojava32.kickstarter.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "users")
public class User implements UserDetails{

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Integer id;

  private String name;
  private String token;
  private String email;
  private String comment;

  @Column (name = "active")
  private boolean isActive;

  public User() {
    isActive = false;
  }

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

  public String getToken() {
    return token;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
