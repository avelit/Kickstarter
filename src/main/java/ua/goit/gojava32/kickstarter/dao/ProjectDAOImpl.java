package ua.goit.gojava32.kickstarter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.model.User;

import java.util.List;

@Repository
public class ProjectDAOImpl extends AbstractDAO<Project> implements ProjectDAO {

  ProjectDAOImpl() {
    super(Project.class);
  }

  @Override
  public List<Project> findFrom(String requestSearch) {
    Session session = getSession();
    Query query = session.createQuery("FROM Project WHERE name LIKE :requestSearch");
    query.setParameter("requestSearch", "%" + requestSearch + "%");
    List<Project> list = query.list();
    return list;
  }

  @Override
  public List<Project> findAllProjectsByUser(User user) {
    Session session = getSession();
    Query query = session.createQuery("FROM Project WHERE user = :user");
    query.setParameter("user", user);
    List<Project> list = query.list();
    return list;
  }

  @Override
  public List<Project> findAll() {
    Session session = getSession();
    Query query = session.createQuery("FROM Project");
    List<Project> list = query.list();
    return list;
  }
}