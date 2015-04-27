package ua.goit.gojava32.kickstarter.controller;

import java.io.IOException;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import ua.goit.gojava32.kickstarter.servlet.Request;
import ua.goit.gojava32.kickstarter.view.ViewModel;

public class ControllerServlet {

  private Logger logger = Logger.getLogger(ControllerServlet.class);

  private HttpServletRequest request;
  private HttpServletResponse response;
  private String[] uriSegments;

  public ControllerServlet(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    uriSegments = request.getRequestURI().split("/");
  }

  public void handleRequest() throws ServletException, IOException {

    Request req = Request.create(request.getMethod(), uriSegments[uriSegments.length - 1]);
    Controller controller = ControllerMap.getController(req);
    ViewModel vm = controller.process(req);

    if (vm.getCommand().equals("sendRedirect")) {
      response.sendRedirect(vm.getView());
    } else if (vm.getCommand().equals("forward")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(vm.getView());
      dispatcher.forward(request, response);
    }
  }
}


