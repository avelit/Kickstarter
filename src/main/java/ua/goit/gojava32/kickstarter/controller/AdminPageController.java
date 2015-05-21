package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import java.util.List;

@Controller
public class AdminPageController {

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "/admin/edit_category", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView editCategory() {
    ModelAndView vm = new ModelAndView("admin_edit_category");
    return vm;
  }

  @RequestMapping(value = "/admin/edit_project", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView editProjects() {

    List<Category> categories = categoryService.findAll();

    ModelAndView vm = new ModelAndView("admin_edit_project");
    vm.addObject("categories", categories);
    return vm;
  }
}
