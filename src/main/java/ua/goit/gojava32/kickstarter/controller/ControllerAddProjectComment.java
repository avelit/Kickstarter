package ua.goit.gojava32.kickstarter.controller;

import org.apache.log4j.Logger;
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

public class ControllerAddProjectComment implements Controller {
  @Override
  public ViewModel process(HttpServletRequest request) {


    ProjectService projectService= new ProjectServiceImpl();
    String textComment= request.getParameter("comment");
    String projectId = request.getParameter("project_id");
    String categoryName = request.getParameter("category");

    Logger logger = Logger.getLogger(this.getClass());
    logger.info("Request params: textComment=" +textComment+ " projectId="+projectId+ " categoryName=" + categoryName);
    Project project = projectService.get(Integer.parseInt(projectId));
    projectService.addComment(textComment ,project);
    ViewModel vm = new ViewModel("/categories/" + categoryName + "/" + project.getName(), "sendRedirect", null);
    return vm;
  }
}
