package ua.goit.gojava32.kickstarter.service;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.data.Data;

public class DataProvider {

  public List<String> getListByCategory(String category){
    return (new Data()).getListByCategory(category);
  }
  
  public Set<String> getCategories(){
    return (new Data()).getCategories();
  }
}
