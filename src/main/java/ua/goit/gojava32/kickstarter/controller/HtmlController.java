package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.service.ImageService;

@Controller
public class HtmlController {

    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/html*", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView htmlGetStart() {
        return new ModelAndView("/html/index");
    }

}