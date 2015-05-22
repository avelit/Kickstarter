package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.ProjectService;

import java.util.List;

@RequestMapping(value = "/webapi")
@RestController
public class JSONController {

  @Autowired
  private CategoryService categoryService;
  @Autowired
  private ProjectService projectService;

  @RequestMapping(value = "/category", method = RequestMethod.GET)
  public List<Category> getAllCategories() {
    return categoryService.findAll();
  }

  @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
  public Category getCategory(@PathVariable("id") int id) {
    Category category = categoryService.get(id);

    return category;
  }

  @RequestMapping(value = "/category/{id}/projects_list", method = RequestMethod.GET)
  public List<Project> getProjectsByCategory(@PathVariable("id") int id) {
    List<Project> projectList = categoryService.findAllProjects(id);
    return projectList;
  }


  @RequestMapping(value = "/project", method = RequestMethod.GET)
  public List<Project> getAllProjects() {
    return projectService.findAll();
  }
  @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
  public Project getAllProjects(@PathVariable("id") int id) {
    return projectService.get(id);
  }


}
