package ua.goit.gojava32.kickstarter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.model.User;

import java.util.List;

@Repository
public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

  UserDAOImpl() {
    super(User.class);
  }

  @Override
  public User findUserByEmail(String email) {
    Session session = getSession();
    Query query = session.createQuery("FROM User WHERE email = :email");
    query.setParameter("email", email);
    List<User> users = query.list();
    if (users.size() > 0 ) {
      return users.get(0);
    }
    return null;
  }
}
