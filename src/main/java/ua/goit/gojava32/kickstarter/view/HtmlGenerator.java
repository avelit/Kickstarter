package ua.goit.gojava32.kickstarter.view;

import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.service.DataProvider;

public class HtmlGenerator {
  public static String getCategoryHtml(String category){
    List<String> list = (new DataProvider()).getListByCategory(category);
    
    if (list == null) {return "";}
    
    StringBuilder result = new StringBuilder();
    for (String element : list) {
      result.append(element).append("<br>");
    }
   return result.toString();
  }

  public static String getHtml(String URI) {
 
    String[] segments = URI.split("/");
    String idCategory = segments[segments.length-1];
    
    String resultHtml = "";
    if (idCategory.equals("categories")){
      resultHtml = getCategoriesHtml();
    } else {
      resultHtml = getCategoryHtml(idCategory);
    }
    return resultHtml;
  }

  private static String getCategoriesHtml() {
    Set<String> set = (new DataProvider()).getCategories();
    
    if (set == null) {return "";}
    
    StringBuilder result = new StringBuilder();
    for (String element : set) {
      result.append("<a href = ./categories/").append(element).append(">").append(element).append("</a><br>");
    }
    return result.toString();
  }
}
