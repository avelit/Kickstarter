package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;

public class ControllerCommon implements Controller{

  String[] uriSegments;

  HttpServletRequest request;

  CategoryService categoryService = new CategoryServiceImpl();
  ProjectService projectService= new ProjectServiceImpl();

  @Override
  public ViewModel process(HttpServletRequest request) {

    this.request = request;
    String URI = request.getRequestURI();
    uriSegments = URI.split("/");

    String jspUrl = "/jsp/" + getJspName();

    ViewModel vm = new ViewModel(jspUrl, "forward", null);

    return vm;
  }

  private String getJspName() {
    String jspName = "";

    if (uriSegments.length == 2) {
      jspName = "categories.jsp";
      request.setAttribute("categories", categoryService.findAll());
    } else if (uriSegments[1].equals("categories") && uriSegments.length > 2) {
      jspName = processCategories();
    }
    return jspName;
  }

  private String processCategories() {
    String jspName = "";
    String categoryName = uriSegments[2];
    request.setAttribute("category_name", categoryName);
    Category category = categoryService.get(categoryName);
    request.setAttribute("category_description", category.getDescription());
    request.getSession().setAttribute("category", category);

    if (uriSegments.length == 3) {
      jspName = "category.jsp";
      request.setAttribute("projects", categoryService.findAllProjects(category));
    } else {
      jspName = processProjects();
    }
    return jspName;
  }

  private String processProjects() {
    String jspName = "";
    if (uriSegments.length == 4) {
      Project project = projectService.get(uriSegments[3].trim());
      request.getSession().setAttribute("project", project);
      request.getSession().setAttribute("comments", projectService.getComments(project));
      request.getSession().setAttribute("blogs", projectService.getBlogs(project));
      jspName = "project.jsp";
    }
    return jspName;
  }
}
