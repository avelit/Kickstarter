package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.view.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerAddProjectComment implements Controller {
  @Override
  public ViewModel process(HttpServletRequest request, HttpServletResponse response) {
//    Project project = (Project)request.getSession().getAttribute("project");
//    projectService.addComment(request.getParameter("comment"),project);
//    response.sendRedirect("/categories/" + request.getParameter("category") + "/" + request.getParameter("project"));
    return null;
  }
}
