package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.View;

public class servlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String[] segments = request.getRequestURI().split("/");
    String idCategory = segments[segments.length-1];
    
    PrintWriter pw = response.getWriter();
    pw.println("<B>projects</B>");
    pw.println((new View()).getCategoryHtml(idCategory));
  }
}