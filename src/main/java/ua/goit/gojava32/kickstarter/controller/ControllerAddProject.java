package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ControllerAddProject  implements Controller{
  @Override
  public ViewModel process(HttpServletRequest request, HttpServletResponse response) {
    String categoryId = request.getParameter("category_id");
    Category category = request.categoryService.get(categoryId);
    String projectName = request.getParameter("project_name");
    String projectDescription = request.getParameter("project_description");
    Project project = request.projectService.add(projectName, projectDescription, category);

    Map<String,Object> atributes = new HashMap<>();
    atributes.put("category",category);

    ViewModel vm = new ViewModel("/categories/" + request.getParameter("category_id"), "sendRedirect", atributes);

    return vm;
  }
}
