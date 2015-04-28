package ua.goit.gojava32.kickstarter.controller;

import org.apache.commons.codec.digest.DigestUtils;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.UserService;
import ua.goit.gojava32.kickstarter.service.UserServiceImpl;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ControllerLogin implements Controller{
  @Override
  public ViewModel process(HttpServletRequest request) {
    String email = request.getParameter("email");
    String pass = request.getParameter("password");
    String token = DigestUtils.md5Hex(email + ":" + pass);

    UserService userService = new UserServiceImpl();
    User user = userService.findUserByToken(token);

    ViewModel vm;
    if (user == null  || !user.isActive()){
      vm = new ViewModel("/login_page", "sendRedirect", null);
    } else {
      request.setAttribute("user", user);
      vm = new ViewModel("/categories", "forward", null);
      vm.addCookie(new Cookie("token", token));
    }
    return vm;
  }
}
