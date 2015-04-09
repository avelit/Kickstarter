package view;

import java.util.List;
import java.util.Set;

import service.DataService;

public class View {
  public String getCategoryHtml(String category){
    List<String> list = (new DataService()).getListByCategory(category);
    
    if (list == null) {return "";}
    
    String result = "";
    result += "<table border = 1>";
    for (String element : list) {
      result += "<tr>" + element+ "</tr>";
    }
    result += "</table>";
    return result;
  }

  public String getHtml(String idCategory) {
    String resultHtml = "";
    if ("categories".equals(idCategory)){
      resultHtml = getCategoriesHtml();
    } else {
      resultHtml = getCategoryHtml(idCategory);
    }
    return resultHtml;
  }

  private String getCategoriesHtml() {
    Set<String> set = (new DataService()).getCategories();
    
    if (set == null) {return "";}
    
    String result = "";
    result += "<table border = 1>";
    for (String element : set) {
      result += "<tr><a href = ./categories/" + element + ">" + element+ "</a></tr>";
    }
    result += "</table>";
    return result;
  }
}
