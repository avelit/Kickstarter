package ua.goit.gojava32.kickstarter.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlogPost {
  private Integer id;
  private String text;
  private Date created;
  private Project project;



  public String getCreatedSimpleFormat(){
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    return dateFormat.format(created);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}
