package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;

public interface CommentDAO extends GenericCRUDDAO<Comment>{

  List<Comment> getByProject(Project project);
}
