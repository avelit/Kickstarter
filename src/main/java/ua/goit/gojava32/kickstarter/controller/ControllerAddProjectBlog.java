package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.view.ViewModel;
import javax.servlet.http.HttpServletRequest;

public class ControllerAddProjectBlog implements Controller {
  @Override
  public ViewModel process(HttpServletRequest request) {
    Project project = (Project)request.getSession().getAttribute("project");
    ProjectService projectService = ServiceModel.getProjectService();
 //   projectService.addBlog(request.getParameter("comment"),project);
    ViewModel vm = new ViewModel("/categories/" + request.getParameter("category") + "/" + request.getParameter("project"), "sendRedirect", null);
    return vm;
  }
}
