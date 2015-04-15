package ua.goit.gojava32.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {

  private static final long serialVersionUID = 1152327662872804857L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String login = request.getParameter("login");
    String pass = request.getParameter("pass");
    
    String jspUrl = request.getContextPath(); 
    
    if (login == "admin" && pass == "") {
      jspUrl += "/admin_edit_category.jsp";
    } else {
      jspUrl += "/empty.jsp";
    }
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(jspUrl);
    dispatcher.forward(request, response);
  }
}
