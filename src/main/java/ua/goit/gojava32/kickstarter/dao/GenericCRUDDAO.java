package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.model.Project;

public interface GenericCRUDDAO<T> {
  void update(T val);
  void delete(Integer id);
  void delete(T val);
  T get(Integer id);
  T get(String name);

}
