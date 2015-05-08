package ua.goit.gojava32.kickstarter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.ProjectService;


import javax.servlet.http.HttpServletRequest;

@Controller
public class SearchController {

  CategoryService categoryService = ServiceModel.getCategoryService();
  ProjectService projectService = ServiceModel.getProjectService();

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  @ResponseBody

  public ModelAndView search(HttpServletRequest request) {
    ModelAndView vm = new ModelAndView("search");
    String requestSearch = request.getParameter("search_text");
    vm.addObject("resultCategoriesSearch", categoryService.findFrom(requestSearch));
    vm.addObject("resultProjectsSearch", projectService.findFrom(requestSearch));

    return vm;
  }
}
