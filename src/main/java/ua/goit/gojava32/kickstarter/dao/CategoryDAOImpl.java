package ua.goit.gojava32.kickstarter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;


@Repository
public class CategoryDAOImpl extends AbstractDAO<Category> implements CategoryDAO {

  CategoryDAOImpl() {
    super(Category.class);
  }

  @Override
  public List<Category> findAll() {
    Session session = getSession();
    Query query = session.createQuery("FROM Category");
    List<Category> list = query.list();
    return list;
  }

  @Override
  public List<Category> findFrom(String requestSearch) {

    Session session = getSession();
    Query query = session.createQuery("FROM Category WHERE name LIKE :requestSearch");
    query.setParameter("requestSearch", "%" + requestSearch + "%");
    List<Category> list = query.list();
    return list;
  }

  @Override
  public List<Project> findAllProjects(Category category) {
    Session session = getSession();
    Query query = session.createQuery("FROM Project WHERE category = :category");
    query.setParameter("category", category);
    List<Project> list = query.list();
    return list;
  }

}
