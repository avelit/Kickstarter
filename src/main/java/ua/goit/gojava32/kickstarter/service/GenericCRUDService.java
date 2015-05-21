package ua.goit.gojava32.kickstarter.service;

public interface GenericCRUDService<T> {
  T update(T val);
  T delete(T val);
  T get(Integer id);
  T add(T val);
}
