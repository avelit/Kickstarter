package ua.goit.gojava32.kickstarter.model;

import javax.persistence.*;

@Entity
@Table (name = "pictures")
public class Image {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private int id;

  @JoinColumn (name = "id_project", nullable = false)
  @OneToOne (fetch = FetchType.EAGER)
  private Project project;

  private byte[] picture;

  public Image(int id, Project project, byte[] picture) {
    this.id = id;
    this.project = project;
    this.picture = picture;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public byte[] getPicture() {
    return picture;
  }

  public void setPicture(byte[] image) {
    this.picture = image;
  }
}
