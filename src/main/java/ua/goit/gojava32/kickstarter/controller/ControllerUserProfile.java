package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.view.ViewModel;
import javax.servlet.http.HttpServletRequest;

public class ControllerUserProfile implements Controller{
  @Override
  public ViewModel process(HttpServletRequest request) {
    User user = (User) request.getAttribute("user");
    request.setAttribute("user_name", user.getName());
    ViewModel vm = new ViewModel("/jsp/user_profile.jsp", "forward", null);
    return vm;
  }
}
