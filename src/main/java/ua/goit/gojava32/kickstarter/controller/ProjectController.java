package ua.goit.gojava32.kickstarter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CommentService;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProjectController {

  @Autowired
  ProjectService projectService;
  @Autowired
  CommentService commentService;
  @Autowired
  CategoryService categoryService;
  @Autowired
  UserService userService;

  @RequestMapping(value = "/project/{id}")
  @ResponseBody
  public ModelAndView showProject(@PathVariable("id") int id, Principal principal){
    Project project = projectService.get(id);
    ModelAndView vm = new ModelAndView("project");

    vm.addObject("project", project);
    vm.addObject("category", project.getCategory());
    vm.addObject("comments", projectService.getProjectComments(project));
    vm.addObject("blogs", projectService.getProjectBlogPosts(project));
    if (principal != null && (project.getUser().getEmail()).equals(principal.getName())) {
      vm.addObject("showAddBlog", true);
    } else {
      vm.addObject("showAddBlog", false);
    }

    return vm;
  }

  @RequestMapping(value = "/project/{id}/delete")
  @ResponseBody
  public ModelAndView deleteProject(@PathVariable("id") int id, Principal principal){
    Project project = projectService.get(id);
    ModelAndView vm;
    if (principal != null && (project.getUser().getEmail()).equals(principal.getName())) {
      project = projectService.delete(project);
      vm = new ModelAndView("redirect:/profile");
    } else {
      vm = new ModelAndView("redirect:/error");
    }
    return vm;
  }

  @RequestMapping(value = "/project/{id}/edit")
  @ResponseBody
  public ModelAndView editProject(@PathVariable("id") int id, Principal principal){
    Project project = projectService.get(id);
    ModelAndView vm;
    if (principal != null && (project.getUser().getEmail()).equals(principal.getName())) {
      vm = new ModelAndView("admin_edit_project");
      List<Category> categories = categoryService.findAll();
      vm.addObject("categories", categories);
      vm.addObject("project",project);
    } else {
      vm = new ModelAndView("redirect:/error");
    }
    return vm;
  }

  @RequestMapping(value = "/project/add", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView addProject(
      @RequestParam("category_id") String strCategoryId,
      @RequestParam("project_description") String projectDescription,
      @RequestParam("project_name") String projectName,
      @RequestParam("video_url") String video,
      @RequestParam("project_id") String project_id,
      Principal principal){

    Integer categoryId = Integer.parseInt(strCategoryId);
    Category category = categoryService.get(categoryId);
    Project project;
    if (project_id == "") {
      project = new Project();
    } else {
      project = projectService.get(Integer.parseInt(project_id));
    }
    project.setCategory(category);
    project.setDescription(projectDescription);
    project.setName(projectName);
    project.setVideo(video);
    project.setUser(userService.findUserByEmail(principal.getName()));
    if (project_id == "") {
      project = projectService.add(project);
    } else {
      project = projectService.update(project);
    }
    ModelAndView vm = new ModelAndView("redirect:/project/" + project.getId());
    return vm;
  }
}