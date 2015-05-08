package ua.goit.gojava32.kickstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
@Controller
public class ErrorPageController{
  @RequestMapping(value = "/error", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView error(HttpServletRequest request) {
    return new ModelAndView("login_page");
  }
}


