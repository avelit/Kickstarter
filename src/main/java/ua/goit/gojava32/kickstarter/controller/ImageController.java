package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.Image;
import ua.goit.gojava32.kickstarter.service.ImageService;

@Controller
public class ImageController {

  @Autowired
  ImageService imageService;

  @RequestMapping(value = "image/{id}")
  @ResponseBody
  public byte[] showImage(@PathVariable int id) {
    Image image = imageService.getByProjectId(id);
    return image.getPicture();
  }
}