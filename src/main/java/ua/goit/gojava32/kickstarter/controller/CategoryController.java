package ua.goit.gojava32.kickstarter.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.service.CategoryService;

@Controller
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "/category/add", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView addCategory(
      @RequestParam("category_name") String categoryName,
      @RequestParam("category_description") String description) throws Exception {
    ModelAndView vm;
    if (categoryName.isEmpty()) {
      vm = new ModelAndView("error_page");
      throw new Exception("Invalid value in the 'category name'");
    } else {
      categoryService.add(categoryName, description);
      vm = new ModelAndView("redirect:/category");
    }
    return vm;
  }


  @RequestMapping(value = {"/category"})
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
  public ModelAndView showCategory(@PathVariable("id") int id) throws Exception {
    Category category = categoryService.get(id);
    ModelAndView vm;
    if (category == null) {
      throw new Exception("No such category.");
    }
    vm = new ModelAndView("category");
    vm.addObject("category", category);
    vm.addObject("projects", categoryService.findAllProjects(category));
    return vm;
  }

  @RequestMapping(value = "/")
  @ResponseBody
  public ModelAndView showIndex() {
    ModelAndView vm = new ModelAndView("index");
    vm.addObject("categories", categoryService.findAll());
    return vm;
  }

  @ExceptionHandler(Exception.class)
  public ModelAndView exceptionHandler(Exception ex) {
    return new ModelAndView("error_page", "error_name", ex.getMessage());
  }
}

