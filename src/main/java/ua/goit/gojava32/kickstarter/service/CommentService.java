package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;

public interface CommentService  extends GenericCRUDService<Comment>{


  List<Comment> getByProject(Project project);
}
