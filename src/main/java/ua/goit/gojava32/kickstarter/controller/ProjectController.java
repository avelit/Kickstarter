package ua.goit.gojava32.kickstarter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.ProjectService;

@Controller
public class ProjectController {

  @Autowired
  ProjectService projectService;

  @RequestMapping(value = "/project/{id}")
  @ResponseBody
  public ModelAndView showProject(@PathVariable("id") int id){
    Project project = projectService.get(id);
    ModelAndView vm = new ModelAndView("project");

    vm.addObject("project", project);
    vm.addObject("category", project.getCategory());
    vm.addObject("comments", projectService.getComments(project));
    vm.addObject("blogs", projectService.getBlogs(project));

    return vm;
  }

}
