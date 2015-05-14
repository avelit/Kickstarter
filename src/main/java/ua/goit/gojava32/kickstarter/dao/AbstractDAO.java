package ua.goit.gojava32.kickstarter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDAO<T> implements GenericCRUDDAO<T> {

  @Autowired
  SessionFactory sessionFactory;

  Session getSession(){
    return sessionFactory.getCurrentSession();
  }

  @Override
  public T add(T val) {
    Session session = getSession();
    session.save(val);
    return val;
  }

  @Override
  public T update(T val) {
    Session session = getSession();
    session.update(val);
    return val;
  }

  @Override
  public T delete(Integer id) {
    Session session = getSession();
    T val = get(id);
    session.delete(val);
    return val;
  }

  @Override
  public T delete(T val) {
    Session session = getSession();
    session.delete(val);
    return val;
  }

  @Override
  public T get(Integer id) {
    Session session = getSession();
    return (T) session.get((Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0], id);
  }
}
