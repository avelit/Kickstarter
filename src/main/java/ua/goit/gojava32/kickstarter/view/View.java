package ua.goit.gojava32.kickstarter.view;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.service.DataService;

public class View {
  public static String getCategoryHtml(String category){
    List<String> list = (new DataService()).getListByCategory(category);
    
    if (list == null) {return "";}
    
    StringBuilder result = new StringBuilder();
    for (String element : list) {
      result.append(element).append("<br>");
    }
   return result.toString();
  }

  public static String getHtml(String idCategory) {
    String resultHtml = "";
    if ("categories".equals(idCategory)){
      resultHtml = getCategoriesHtml();
    } else {
      resultHtml = getCategoryHtml(idCategory);
    }
    return resultHtml;
  }

  private static String getCategoriesHtml() {
    Set<String> set = (new DataService()).getCategories();
    
    if (set == null) {return "";}
    
    StringBuilder result = new StringBuilder();
    for (String element : set) {
      result.append("<a href = ./categories/").append(element).append(">").append(element).append("</a><br>");
    }
    return result.toString();
  }
}
