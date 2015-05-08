package ua.goit.gojava32.kickstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

 @Controller
public class AdminPageController {

  @RequestMapping(value = "/admin/edit_category", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView editCategory() {
    ModelAndView vm = new ModelAndView("admin_edit_category");
    return vm;
  }
   @RequestMapping(value = "/admin/edit_project", method = RequestMethod.GET)
   @ResponseBody
   public ModelAndView editProjects() {
     ModelAndView vm = new ModelAndView("admin_edit_project");
     return vm;
   }


}
