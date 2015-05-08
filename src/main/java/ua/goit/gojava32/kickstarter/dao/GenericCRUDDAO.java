package ua.goit.gojava32.kickstarter.dao;

public interface GenericCRUDDAO<T> {
  void update(T val);
  void delete(Integer id);
  void delete(T val);
  T get(Integer id);
  T add(T val);

}
