package ua.goit.gojava32.kickstarter.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment implements Comparable {

  private Integer id;
  private String comment;
  private Date created;
  private Project project;

  public Comment() {

  }

  public Comment(Integer id, String comment, Date dateOfCreation, Project project) {
    this.id = id;
    this.comment = comment;
    this.created = dateOfCreation;
    this.project = project;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Comment comment = (Comment) o;

    if (id != comment.id) return false;
    if (getComment() != null ? !getComment().equals(comment.getComment()) : comment.getComment() != null)
      return false;
    return !(created != null ? !created.equals(comment.created) : comment.created != null);

  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (getComment() != null ? getComment().hashCode() : 0);
    result = 31 * result + (created != null ? created.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm");
    return "(" + format.format(getCreated()) + ") " + getComment();
  }


  public void setId(Integer id) {
    this.id = id;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String text) {
    this.comment = text;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  @Override
  public int compareTo(Object o) {
    if (o == null) {
      return -1;
    }
    Comment entry = (Comment) o;
    return -getCreated().compareTo(entry.getCreated());
  }
}
