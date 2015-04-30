package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ControllerLogout implements Controller{
  @Override
  public ViewModel process(HttpServletRequest request) {
    final String TOKEN = "token";

    ViewModel vm;
    vm = new ViewModel("/categories", "sendRedirect", null);
    Cookie cookie = new Cookie(TOKEN,"");
    vm.addCookie(cookie);
    return vm;
  }
}
