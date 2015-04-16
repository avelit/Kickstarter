package ua.goit.gojava32.kickstarter.controller;

import java.io.IOException;
import ua.goit.gojava32.kickstarter.service.DataProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlController {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private String[] uriSegments;

  public HtmlController(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    uriSegments = request.getRequestURI().split("/");
  }

  public void handleRequest() throws ServletException, IOException {
    String jspUrl = request.getContextPath() + "/jsp/";
    jspUrl += getJspName();

    RequestDispatcher dispatcher = request.getRequestDispatcher(jspUrl);
    dispatcher.forward(request, response);
  }

  private String getJspName() {
    String jspName = "";

    if (uriSegments.length == 1) {
      jspName = "index.jsp";
    } else if (uriSegments[1].equals("categories") && uriSegments.length == 2) {
      jspName = "categories.jsp";
      request.setAttribute("categories", (new DataProvider()).getCategories());
    } else if (uriSegments[1].equals("categories") && uriSegments.length > 2) {
      jspName = processCategories();
    }
    return jspName;
  }

  private String processCategories() {
    String jspName = "";
    String categoryName = uriSegments[2];
    request.setAttribute("category_name", categoryName);

    if (uriSegments.length == 3) {
      jspName = "category.jsp";
      request.setAttribute("projects", (new DataProvider()).getListByCategory(categoryName));
    } else {
      jspName = processProjects();
    }
    return jspName;
  }

  private String processProjects() {
    String jspName = "";
    if (uriSegments.length == 4) {
      request.setAttribute("project_name", uriSegments[3]);
      jspName = "project.jsp";
    }
    return jspName;
  }
}
