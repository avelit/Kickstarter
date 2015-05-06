package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.service.UserService;
import ua.goit.gojava32.kickstarter.view.ViewModel;
import ua.goit.gojava32.kickstarter.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

//@Component("userActivateController")//not work
public class ControllerUserActivate implements Controller {

  //@Autowired//not work
  private UserService userService = ServiceModel.getUserService();

  @Override
  public ViewModel process(HttpServletRequest request) {
    String token = request.getParameter("token");
    User user = userService.findUserByToken(token);
    ViewModel vm = new ViewModel("/categories", "sendRedirect", null);
    if (user != null){
      user.setIsActive(true);
      userService.update(user);
      request.setAttribute("user", user);
      vm.addCookie(new Cookie("token", token));
    }
    return vm;
  }
}
