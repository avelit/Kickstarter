package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public class ControllerAdminPanelProject implements Controller{
  @Override
  public ViewModel process(HttpServletRequest request) {
    CategoryService categoryService = ServiceModel.getCategoryService();
    Set<Category> categories = categoryService.findAll();
    request.setAttribute("categories", categories);
    ViewModel vm = new ViewModel("/jsp/admin_edit_project.jsp", "forward", null);
    return vm;
  }
}
