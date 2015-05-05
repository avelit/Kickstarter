package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;

public class ControllerSearch implements Controller {

  CategoryService categoryService = ServiceModel.getCategoryService();
  ProjectService projectService = ServiceModel.getProjectService();
  ViewModel vm;
  @Override
  public ViewModel process(HttpServletRequest request) {
    vm = new ViewModel("/jsp/search.jsp", "forward", null);
    String requestSearch = request.getParameter("search_text");
    request.setAttribute("resultCategoriesSearch", categoryService.findFrom(requestSearch));
    request.setAttribute("resultProjectsSearch", projectService.findFrom(requestSearch));
    return vm;
  }
}
