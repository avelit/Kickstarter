package ua.goit.gojava32.kickstarter.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.ProjectService;


@Controller
public class CategoryController {


  public CategoryController() {
  }

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private ProjectService projectService;

  @RequestMapping(value = "/category", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView addCategory(
      @RequestParam("category_name") String categoryName,
      @RequestParam("category_description") String description) {

    categoryService.add(categoryName, description);
    ModelAndView vm = new ModelAndView("redirect:/categories");
    return vm;
  }


  @RequestMapping(value = "/category")
  @ResponseBody
  public ModelAndView listAllCategories(){
    Logger logger = Logger.getLogger(this.getClass());
    logger.trace("listAllCategories");
    ModelAndView vm = new ModelAndView("categories");
    vm.addObject("categories", categoryService.findAll());
    return vm;
  }

  @RequestMapping(value = "/category/{id}")
  @ResponseBody
  public ModelAndView showCategory(@PathVariable("id") int id){
    Category category = categoryService.get(id);
    ModelAndView vm = new ModelAndView("category");
    vm.addObject("category", category);
    vm.addObject("projects", categoryService.findAllProjects(category));
    return vm;
  }

}

