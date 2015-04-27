package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;

public class ControllerLogin implements Controller{
  @Override
  public ViewModel process(HttpServletRequest request) {
    //TODO check authorization
    request.setAttribute("user", new User("ddd","fff",true));
    ViewModel vm = new ViewModel("/categories", "forward", null);
    return vm;

  }
}
