package ua.goit.gojava32.kickstarter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Image;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private UserService userService;

  @Autowired
  ImageService imageService;

  @RequestMapping(value = "/project/{id}")
  @ResponseBody
  public ModelAndView showProject(@PathVariable("id") int id, Principal principal) throws Exception {
    Project project = projectService.get(id);
    ModelAndView vm;
    if (project == null) {
      throw new Exception("No such project.");
    }
    vm = new ModelAndView("project");
    vm.addObject("project", project);
    Image image = imageService.getByProjectId(id);
    vm.addObject("image", image != null);
    vm.addObject("category", project.getCategory());
    vm.addObject("comments", projectService.getProjectComments(project));
    vm.addObject("blogs", projectService.getProjectBlogPosts(project));
    if (isOwner(principal, project)) {
      vm.addObject("showAddBlog", true);
    } else {
      vm.addObject("showAddBlog", false);
    }
    return vm;
  }

  private boolean isOwner(Principal principal, Project project) {
    return principal != null && (project.getUser().getEmail()).equals(principal.getName());
  }

  @RequestMapping(value = "/project/{id}/delete")
  @ResponseBody
  public ModelAndView deleteProject(@PathVariable("id") int id, Principal principal) throws Exception {
    Project project = projectService.get(id);
    if (project == null) {
      throw new Exception("No such project.");
    }
    ModelAndView vm;
    if (isOwner(principal, project)) {
      project = projectService.delete(project);
      vm = new ModelAndView("redirect:/profile");
    } else {
      vm = new ModelAndView("redirect:/error");
    }
    return vm;
  }

  @RequestMapping(value = "/project/{id}/edit")
  @ResponseBody
  public ModelAndView editProject(@PathVariable("id") int id, Principal principal) throws Exception {
    Project project = projectService.get(id);
    if (project == null) {
      throw new Exception("No such project.");
    }
    ModelAndView vm;
    if (isOwner(principal, project)) {
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
      int category_id,
      @RequestParam("project_description") String projectDescription,
      @RequestParam("project_name") String projectName,
      @RequestParam("file") MultipartFile file,
      @RequestParam("video_url") String video,
      Principal principal) {

    Category category = categoryService.get(category_id);
    Project project = new Project();
    project.setCategory(category);
    project.setDescription(projectDescription);
    project.setName(projectName);
    project.setVideo(video);
    project.setUser(userService.findUserByEmail(principal.getName()));
    project = projectService.add(project);
    if (!file.isEmpty()) {
      try {
        byte[] bytes = file.getBytes();
        Image image = new Image();
        image.setProject(project);
        image.setPicture(bytes);
        imageService.add(image);
      } catch (Exception e) {
        throw new RuntimeException("Failed to upload file => " + e.getMessage());
      }
    }
    ModelAndView vm = new ModelAndView("redirect:/project/" + project.getId());
    return vm;
  }

  @RequestMapping(value = "/project/edit", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView editProject(
          @RequestParam("category_id") String category_id,
          @RequestParam("project_id") String project_id,
          @RequestParam("project_description") String projectDescription,
          @RequestParam("project_name") String projectName,
          @RequestParam("file") MultipartFile file,
          @RequestParam("video_url") String video,
          Principal principal) {

    Category category = categoryService.get(Integer.parseInt(category_id));
    Project project = projectService.get(Integer.parseInt(project_id));
    ModelAndView vm;
    if (isOwner(principal, project)) {
      project.setCategory(category);
      project.setDescription(projectDescription);
      project.setName(projectName);
      project.setVideo(video);
      project = projectService.update(project);
      if (!file.isEmpty()) {
        try {
          byte[] bytes = file.getBytes();
          Image image = new Image();
          image.setProject(project);
          image.setPicture(bytes);
          imageService.add(image);
        } catch (Exception e) {
          throw new RuntimeException("Failed to upload file => " + e.getMessage());
        }
      }
      vm = new ModelAndView("redirect:/project/" + project.getId());
    } else {
      vm = new ModelAndView("redirect:/error");
    }
    return vm;
  }

  @ExceptionHandler(Exception.class)
  public ModelAndView exceptionHandler(Exception ex) {
    return new ModelAndView("error_page", "error_name", ex.getMessage());
  }

}