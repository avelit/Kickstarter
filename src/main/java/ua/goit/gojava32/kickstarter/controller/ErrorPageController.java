package ua.goit.gojava32.kickstarter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;

public class ErrorPageController{
  @RequestMapping(value = "/error", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView error(HttpServletRequest request) {
    return new ModelAndView("login_page");
  }
}


