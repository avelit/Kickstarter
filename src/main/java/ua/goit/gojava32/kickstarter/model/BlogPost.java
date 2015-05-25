package ua.goit.gojava32.kickstarter.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table (name = "blogs")
public class BlogPost {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Integer id;

  private String text;
  private Date created;

  @JoinColumn ( name = "id_project", nullable = false )
  @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
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
