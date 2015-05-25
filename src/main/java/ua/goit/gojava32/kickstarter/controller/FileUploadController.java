package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.service.ImageService;


@Controller
public class FileUploadController {

  @Autowired
  private ImageService imageService;

  @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        byte[] bytes = file.getBytes();

      } catch (Exception e) {
        throw new RuntimeException("Failed to upload " + name + " => " + e.getMessage());
      }
    }
    return new ModelAndView("user_profile");
  }
}
