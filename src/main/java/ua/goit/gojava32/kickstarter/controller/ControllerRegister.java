package ua.goit.gojava32.kickstarter.controller;

import org.apache.commons.codec.digest.DigestUtils;
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
    String token = DigestUtils.md5Hex(email + ":" + pass);

    userService.add(name, token, email, false);
    return new ViewModel("/categories", "forward", null);
  }
}
