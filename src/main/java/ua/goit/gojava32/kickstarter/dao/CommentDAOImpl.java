package ua.goit.gojava32.kickstarter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;


@Repository
public class CommentDAOImpl extends AbstractDAO<Comment> implements CommentDAO{

  CommentDAOImpl() {
    super(Comment.class);
  }

  @Override
  public List<Comment> getByProject(Project project) {

    Session session = getSession();
    Query query = session.createQuery("SELECT c FROM Comment c WHERE c.project = :project");
    query.setParameter("project", project);
    List<Comment> list = query.list();
    return list;
  }
}
