package ua.goit.gojava32.kickstarter.service;

import org.springframework.stereotype.Component;
import ua.goit.gojava32.kickstarter.dao.CommentDAO;
import ua.goit.gojava32.kickstarter.dao.CommentDAOImpl;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

  CommentDAO commentDAO = new CommentDAOImpl();

  @Override
  public void update(Comment val) {
  }

  @Override
  public void delete(Comment val) {

  }

  @Override
  public Comment get(Integer id) {
    return null;
  }


  @Override
  public Comment add(Comment val) {
    return commentDAO.add(val);
  }

  @Override
  public List<Comment> getByProject(Project project) {
    return commentDAO.getByProject(project);
  }
}
