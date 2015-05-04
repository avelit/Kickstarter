package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.dao.CommentDAO;
import ua.goit.gojava32.kickstarter.dao.CommentDAOImpl;
import ua.goit.gojava32.kickstarter.model.Comment;

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
  public Comment get(String name) {
    return null;
  }

  @Override
  public Comment add(Comment val) {
    return commentDAO.add(val);
  }

}
