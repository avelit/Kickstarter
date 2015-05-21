package ua.goit.gojava32.kickstarter.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.goit.gojava32.kickstarter.model.enums.UserRoleEnum;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "users")
public class User implements UserDetails {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private String email;
  private String password;
  @Transient
  private List<UserRoleEnum> Authorities;

  @Column (name = "active")
  private boolean isActive;

  public User() {
    isActive = false;
  }

  public User(String name, String email, String password, Boolean isActive) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.isActive = isActive;
  }

  public User(Integer id, String name, String email, String password, Boolean isActive) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.isActive = isActive;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    Set<GrantedAuthority> roles = new HashSet();
    roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

    return roles;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return isActive;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User user = (User) obj;
    if (user.getId() != this.id){
      return false;
    }
    return true;
  }

  @Override
  public int hashCode(){
    final int prime = 31;
    int result = 1;
    if (this.id == null) {
      return 1;
    }
    result = prime * result + this.id;
    return result;
  }

  @Override
  public String toString() {
    if (email == null) {
      return email;
    }
    return getClass().getName();
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

}
