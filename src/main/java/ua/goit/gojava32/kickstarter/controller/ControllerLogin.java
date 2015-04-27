package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerLogin implements Controller {
  @Override
  public ViewModel process(HttpServletRequest request, HttpServletResponse response) {
//    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login_page.jsp");
//    dispatcher.forward(request, response);
    return null;
  }
}
