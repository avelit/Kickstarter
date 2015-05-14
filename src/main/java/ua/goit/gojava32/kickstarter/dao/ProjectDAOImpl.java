package ua.goit.gojava32.kickstarter.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.connections.ConnectionPool;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public class ProjectDAOImpl extends AbstractDAO<Project> implements ProjectDAO {

  @Override
  public List<Project> findFrom(String requestSearch) {
    Session session = getSession();
    Query query = session.createQuery("FROM Project WHERE name LIKE :requestSearch");
    query.setParameter("requestSearch", requestSearch);
    List<Project> list = query.list();
    return list;
  }
}