package ua.goit.gojava32.kickstarter.controller;

import java.io.IOException;
import ua.goit.gojava32.kickstarter.service.DataProvider;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class HtmlController {

  public static String getJspUrl(HttpServletRequest request, String URI) throws ServletException, IOException {
    String[] segments = URI.split("/");
    String jspUrl = request.getContextPath() + "/jsp";

    if (URI.equals("/categories")) {
      jspUrl += "/categories.jsp";
      request.setAttribute("categories", (new DataProvider()).getCategories());
    } else {
      jspUrl += "/category.jsp";
      String categoryName = segments[segments.length - 1];
      request.setAttribute("projects", (new DataProvider()).getListByCategory(categoryName));
    }
    return jspUrl;
  }
}
