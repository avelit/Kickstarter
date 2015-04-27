package ua.goit.gojava32.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.goit.gojava32.kickstarter.controller.Controller;
import ua.goit.gojava32.kickstarter.controller.ControllerMap;
import ua.goit.gojava32.kickstarter.controller.ControllerServlet;
import ua.goit.gojava32.kickstarter.view.ViewModel;

//@WebServlet("/categories/*")
public class KickstarterServlet extends HttpServlet {
  private static final long serialVersionUID = -5152327662872804857L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    (new ControllerServlet(request, response)).handleRequest();

    handle(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    (new ControllerServlet(request, response)).handleRequest();

    handle(request, response);
  }

  private void handle(HttpServletRequest request, HttpServletResponse response) {

    String mapKey = request.getMethod() + "_" + request.getRequestURI();
    Controller controller = ControllerMap.getController(mapKey);
    ViewModel viewModel = controller.process(request);


  }

}

