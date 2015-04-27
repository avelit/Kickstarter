package ua.goit.gojava32.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.goit.gojava32.kickstarter.controller.Controller;
import ua.goit.gojava32.kickstarter.controller.ControllerMap;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.view.ViewModel;

//@WebServlet("/categories/*")
public class KickstarterServlet extends HttpServlet {
  private static final long serialVersionUID = -5152327662872804857L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    handleRequest(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    handleRequest(request, response);
  }

  private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String[] uriSegments = request.getRequestURI().split("/");
    Controller controller = ControllerMap.getController(request.getMethod().toLowerCase() + "_" + uriSegments[uriSegments.length - 1]);
    ViewModel vm = controller.process(request);

    User user = (User)request.getAttribute("user");
    if (user != null){
      response.addCookie(new Cookie("token", user.getToken()));
    }

    if (vm.getCommand().equals("sendRedirect")) {
      response.sendRedirect(vm.getView());
    } else if (vm.getCommand().equals("forward")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(vm.getView());
      dispatcher.forward(request, response);
    }
  }

}

