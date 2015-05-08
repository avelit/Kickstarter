package ua.goit.gojava32.kickstarter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login_page")
public class ControllerLoginPage{

  @RequestMapping()
  @ResponseBody
  public ModelAndView process() {
    ModelAndView vm = new ModelAndView("login_page");
    return vm;
  }
}
