package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.model.BlogPost;
import ua.goit.gojava32.kickstarter.model.Project;

import javax.persistence.Entity;
import java.util.List;

public interface BlogPostDAO extends GenericCRUDDAO<BlogPost> {
  List<BlogPost> getByProject(Project project);
}
