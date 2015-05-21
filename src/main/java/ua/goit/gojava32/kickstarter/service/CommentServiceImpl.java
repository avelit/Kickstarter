package ua.goit.gojava32.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.dao.CommentDAO;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;

@Transactional
@Service
public class CommentServiceImpl implements CommentService {
  @Autowired
  CommentDAO commentDAO;

  @Override
  public Comment update(Comment val) {
    return commentDAO.update(val);
  }

  @Override
  public Comment delete(Comment val) {
    return commentDAO.delete(val);
  }

  @Override
  public Comment get(Integer id) {
    return commentDAO.get(id);
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
