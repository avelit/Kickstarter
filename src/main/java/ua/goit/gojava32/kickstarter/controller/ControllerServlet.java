package ua.goit.gojava32.kickstarter.controller;

import java.io.IOException;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ControllerServlet {

  private Logger logger = Logger.getLogger(ControllerServlet.class);
  
  private HttpServletRequest request;
  private HttpServletResponse response;
  private String[] uriSegments;

  private CategoryService categoryService = new CategoryServiceImpl();
  private ProjectService projectService = new ProjectServiceImpl();

  public ControllerServlet(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    uriSegments = request.getRequestURI().split("/");
  }

  public void handleRequest() throws ServletException, IOException {

    if ("addCategory".equals(uriSegments[uriSegments.length - 1])) {
      String categoryName = request.getParameter("category_name");
      String description  = request.getParameter("category_description");
      Category category = categoryService.add(categoryName, description);
      category.setDescription(request.getParameter("category_description"));
      response.sendRedirect("/categories");
    } else if ("addProject".equals(uriSegments[uriSegments.length - 1])) {
      Category category = (Category)request.getSession().getAttribute("category");
      String projectName = request.getParameter("project_name");
      String projectDescription = request.getParameter("project_description");
      Project project = projectService.add(projectName, projectDescription, category);
      response.sendRedirect("/categories/" + request.getParameter("category_name"));
    } else if ("addProjectComment".equals(uriSegments[uriSegments.length - 1])) {
      Project project = (Project)request.getSession().getAttribute("project");
      projectService.addComment(request.getParameter("comment"),project);
      response.sendRedirect("/categories/" + request.getParameter("category") + "/" + request.getParameter("project"));
    } else if ("addProjectBlog".equals(uriSegments[uriSegments.length - 1])) {
      Project project = (Project)request.getSession().getAttribute("project");
      projectService.addBlog(request.getParameter("comment"),project);
      response.sendRedirect("/categories/" + request.getParameter("category") + "/" + request.getParameter("project"));
    } else if ("login_page".equals(uriSegments[uriSegments.length - 1])) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login_page.jsp");
      dispatcher.forward(request, response);
    } else if ("registration_page".equals(uriSegments[uriSegments.length - 1])) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/registration.jsp");
      dispatcher.forward(request, response);
    } else {
      String jspUrl = "/jsp/";
      jspUrl += getJspName();

      RequestDispatcher dispatcher = request.getRequestDispatcher(jspUrl);
      dispatcher.forward(request, response);
    }
  }

  private String getJspName() {
    String jspName = "";

    if (uriSegments[1].equals("categories") && uriSegments.length == 2) {
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
