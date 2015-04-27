package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.UserService;
import ua.goit.gojava32.kickstarter.service.UserServiceImpl;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;

public class ControllerRegister implements Controller {
  @Override
  public ViewModel process(HttpServletRequest request) {
    UserService userService = new UserServiceImpl();

    String name = request.getParameter("name");
    String pass = request.getParameter("password");
    String email =  request.getParameter("email");

    User user = userService.add(name, pass, email, false);
    ViewModel vm = new ViewModel("/categories", "forward", null);

    return vm;
  }
}
