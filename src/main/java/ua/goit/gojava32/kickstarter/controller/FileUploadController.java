package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.Image;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.ImageService;
import ua.goit.gojava32.kickstarter.service.ProjectService;


@Controller
public class FileUploadController {

  @Autowired
  private ImageService imageService;
  @Autowired
  private ProjectService projectService;

  @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView uploadFileHandler(
          @RequestParam("file") MultipartFile file,
          @RequestParam("project_id") int project_id) {

    Project project = projectService.get(project_id);
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
    return new ModelAndView("redirect:/project/" + project.getId());
  }
}
