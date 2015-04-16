package ua.goit.gojava32.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.goit.gojava32.kickstarter.controller.HtmlController;

@WebServlet("/categories/*")
public class KickstarterServlet extends HttpServlet {
  private static final long serialVersionUID = -5152327662872804857L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HtmlController.handleRequest(request, response);
  }
}