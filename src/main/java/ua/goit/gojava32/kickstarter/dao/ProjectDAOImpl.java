package ua.goit.gojava32.kickstarter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.model.Project;
import java.util.List;

@Transactional
@Repository
public class ProjectDAOImpl extends AbstractDAO<Project> implements ProjectDAO {

  @Override
  public List<Project> findFrom(String requestSearch) {
    Session session = getSession();
    Query query = session.createQuery("FROM Project WHERE name LIKE %:requestSearch%");
    query.setParameter("requestSearch", requestSearch);
    List<Project> list = query.list();
    return list;
  }
}