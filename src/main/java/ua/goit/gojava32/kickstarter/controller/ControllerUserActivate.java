package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.service.UserService;
import ua.goit.gojava32.kickstarter.view.ViewModel;
import ua.goit.gojava32.kickstarter.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ControllerUserActivate implements Controller {
  @Override
  public ViewModel process(HttpServletRequest request) {
    UserService userService = ServiceModel.getUserService();
    String token = request.getParameter("token");
    User user = userService.findUserByToken(token);
    ViewModel vm = new ViewModel("/categories", "forward", null);;
    if (user != null){
      user.setIsActive(true);
      userService.update(user);
      request.setAttribute("user", user);
      vm.addCookie(new Cookie("token", token));
    }
    return vm;
  }
}
