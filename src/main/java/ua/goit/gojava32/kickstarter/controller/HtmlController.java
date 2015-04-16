package ua.goit.gojava32.kickstarter.controller;

import java.io.IOException;
import ua.goit.gojava32.kickstarter.service.DataProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlController {

  public static void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri = request.getRequestURI();
    String[] segments = uri.split("/");
    String jspUrl = request.getContextPath() + "/jsp";

    if (uri.equals("/categories")) {
      jspUrl += "/categories.jsp";
      request.setAttribute("categories", (new DataProvider()).getCategories());
    } else {
      jspUrl += "/category.jsp";
      String categoryName = segments[segments.length - 1];
      request.setAttribute("projects", (new DataProvider()).getListByCategory(categoryName));
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher(jspUrl);
    dispatcher.forward(request, response);
  }
}
