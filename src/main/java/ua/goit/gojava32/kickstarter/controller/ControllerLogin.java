package ua.goit.gojava32.kickstarter.controller;

import org.apache.commons.codec.digest.DigestUtils;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.UserService;
import ua.goit.gojava32.kickstarter.service.UserServiceImpl;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;

public class ControllerLogin implements Controller{
  @Override
  public ViewModel process(HttpServletRequest request) {
    String email = request.getParameter("email");
    String pass = request.getParameter("password");
    String token = DigestUtils.md5Hex(email + ":" + pass);

    UserService userService = new UserServiceImpl();
    User user = userService.findUserByToken(token);

    request.setAttribute("user", user);
    return new ViewModel("/categories", "forward", null);
  }
}
