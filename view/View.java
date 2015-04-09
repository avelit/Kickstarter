package view;

import java.util.List;

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
}
