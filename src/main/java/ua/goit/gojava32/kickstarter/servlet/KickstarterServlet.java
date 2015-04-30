package ua.goit.gojava32.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import ua.goit.gojava32.kickstarter.controller.Controller;
import ua.goit.gojava32.kickstarter.controller.ControllerMap;
import ua.goit.gojava32.kickstarter.factory.FactoryDB;
import ua.goit.gojava32.kickstarter.view.ViewModel;

public class KickstarterServlet extends HttpServlet {
  private static final long serialVersionUID = -5152327662872804857L;

  @Override
  public void init() throws ServletException {
    super.init();
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    handleRequest(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    handleRequest(request, response);
  }

  private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Logger logger = Logger.getLogger(this.getClass());
    String Uri = request.getRequestURI();
    logger.info("query for URL:" + Uri);

    String[] uriSegments = Uri.split("/");
    Controller controller = ControllerMap.getController(request.getMethod().toLowerCase() + "_" + uriSegments[uriSegments.length - 1]);
    ViewModel vm = controller.process(request);

    Cookie newCookie = vm.getNewCookie();
    if (newCookie != null) {
      response.addCookie(newCookie);
    }

    if (vm.getCommand().equals("sendRedirect")) {
      response.sendRedirect(vm.getView());
    } else if (vm.getCommand().equals("forward")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(vm.getView());
      dispatcher.forward(request, response);
    }
  }

}

