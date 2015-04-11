package ua.goit.gojava32.kickstarter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.goit.gojava32.kickstarter.view.View;

public class servlet extends HttpServlet {

  private static final long serialVersionUID = -5152327662872804857L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String[] segments = request.getRequestURI().split("/");
    String idCategory = segments[segments.length-1];
    
    PrintWriter pw = response.getWriter();
    pw.println("<B>projects</B>");
    pw.println((new View()).getHtml(idCategory));
  }
}