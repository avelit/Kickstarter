package ua.goit.gojava32.kickstarter.service;

public interface GenericCRUDService<T> {
  void update(T val);
  void delete(T val);
  T get(Integer id);
  T get(String name);
  T add(T val);
}
