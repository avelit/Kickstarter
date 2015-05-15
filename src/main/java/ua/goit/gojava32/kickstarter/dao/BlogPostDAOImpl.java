package ua.goit.gojava32.kickstarter.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.model.BlogPost;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;


@Repository
public class BlogPostDAOImpl extends AbstractDAO<BlogPost> implements BlogPostDAO{

  BlogPostDAOImpl() {
    super(BlogPost.class);
  }

  @Override
  public List<BlogPost> getByProject(Project project) {
    Session session = getSession();
    Query query = session.createQuery("SELECT  b FROM BlogPost b WHERE b.project = :project");
    query.setParameter("project", project);
    List<BlogPost> list = query.list();
    return list;
  }

}
