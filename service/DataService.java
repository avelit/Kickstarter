package service;

import java.util.List;

import data.Data;

public class DataService {
  public List<String> getListByCategory(String category){
    return (new Data()).getMap().get(category);
  }
}
