package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.ProjectService;

@Controller
public class SearchController {

  @Autowired
  private CategoryService categoryService;
  @Autowired
  private ProjectService projectService;

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView search(@RequestParam("search_text") String searchText) {
    ModelAndView vm = new ModelAndView("search");
    vm.addObject("resultCategoriesSearch", categoryService.findFrom(searchText));
    vm.addObject("resultProjectsSearch", projectService.findFrom(searchText));
    return vm;
  }
}
