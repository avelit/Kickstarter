package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
  public ViewModel process(HttpServletRequest request, HttpServletResponse response);
}
