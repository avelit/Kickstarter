package ua.goit.gojava32.kickstarter.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import ua.goit.gojava32.kickstarter.view.View;

public class servlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String[] segments = request.getRequestURI().split("/");
    String idCategory = segments[segments.length-1];
    
    PrintWriter pw = response.getWriter();
    pw.println("<B>projects</B>");
    pw.println((new View()).getHtml(idCategory));
  }
}