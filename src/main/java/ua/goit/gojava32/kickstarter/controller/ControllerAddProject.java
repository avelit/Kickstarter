package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerAddProject  implements Controller{
  @Override
  public ViewModel process(HttpServletRequest request) {

    CategoryService categoryService = new CategoryServiceImpl();
    ProjectService projectService= new ProjectServiceImpl();

    String categoryId = request.getParameter("category_id");
    Category category = categoryService.get(categoryId);
    String projectName = request.getParameter("project_name");
    String projectDescription = request.getParameter("project_description");
    Project project = projectService.add(projectName, projectDescription, category);

    Map<String,Object> atributes = new HashMap<>();
    atributes.put("category",category);

    ViewModel vm = new ViewModel("/categories/" + request.getParameter("category_id"), "sendRedirect", atributes);

    return vm;
  }
}
