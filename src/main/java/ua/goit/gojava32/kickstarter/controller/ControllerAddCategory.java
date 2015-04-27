package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.servlet.Request;
import ua.goit.gojava32.kickstarter.view.ViewModel;

public class ControllerAddCategory implements Controller{

  @Override
  public ViewModel process(Request request) {
    String categoryName = request.getParameter("category_name");
    String description  = request.getParameter("category_description");
    Category category = request.categoryService.add(categoryName, description);
    category.setDescription(request.getParameter("category_description"));

    ViewModel vm = new ViewModel("/categories", "sendRedirect", null);

    return vm;
  }
}
