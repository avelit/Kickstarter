package ua.goit.gojava32.kickstarter.controller;

import java.io.IOException;

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

  public ControllerServlet(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
  }

  public void handleRequest() throws ServletException, IOException {

    Request req = Request.create(request.getMethod(), request.getRequestURI());
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


