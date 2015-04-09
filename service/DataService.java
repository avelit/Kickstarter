package service;

import java.util.List;
import java.util.Set;

import data.Data;

public class DataService {

  public List<String> getListByCategory(String category){
    return (new Data()).getListByCategory(category);
  }
  
  public Set<String> getCategories(){
    return (new Data()).getCategories();
  }
}
