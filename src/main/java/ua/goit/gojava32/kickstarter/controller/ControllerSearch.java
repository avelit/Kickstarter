package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;

public class ControllerSearch implements Controller {

  ViewModel vm;
  @Override
  public ViewModel process(HttpServletRequest request) {
    vm = new ViewModel("/jsp/search.jsp", "sendRedirect", null);
    String searchRequest = request.getParameter("search_text");

    return vm;
  }
}
