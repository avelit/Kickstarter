package ua.goit.gojava32.kickstarter.dao;

public interface GenericCRUDDAO<T> {
  T add(T val);
  T update(T val);
  T delete(Integer id);
  T delete(T val);
  T get(Integer id);
}
