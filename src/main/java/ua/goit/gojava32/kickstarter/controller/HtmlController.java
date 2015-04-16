package ua.goit.gojava32.kickstarter.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import ua.goit.gojava32.kickstarter.service.DataProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlController {
  /*
  public static String getCategoryHtml(String category){
    List<String> list = (new DataProvider()).getListByCategory(category);
    
    if (list == null) {
      return "";
    }
    
    StringBuilder result = new StringBuilder();
    for (String element : list) {
      result.append(element).append("<br>");
    }
   return result.toString();
  }

  public static String getHtml(String URI) {
    String[] segments = URI.split("/");
    String idCategory = "";
    if (URI.equals("/categories")) {
      idCategory = "categories";
    } else {
      idCategory = segments[segments.length - 1];
    }

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
    
    if (set == null) {
      return "";
    }
    
    StringBuilder result = new StringBuilder();
    for (String element : set) {
      result.append("<a href = ./categories/").append(element).append(">").append(element).append("</a><br>");
    }
    return result.toString();
  }
  */

  public static void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String URI = request.getRequestURI();
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

    RequestDispatcher dispatcher = request.getRequestDispatcher(jspUrl);
    dispatcher.forward(request, response);
  }
}
