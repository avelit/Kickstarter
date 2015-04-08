package view;

import java.util.List;

import service.DataService;

public class View {
  public String getHtml(String category){
    List<String> list = (new DataService()).getListByCategory(category);
    String result = "";
    result += "<tr>";
    for (String element : list) {
      result += "<td>" + element+ "</td>";
    }
    result += "</tr>";
    return result;
  }
}
