package ua.goit.gojava32.kickstarter.controller;

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

  CategoryService categoryService;
  ProjectService projectService;

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
    return vm;
  }


  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }
  @Autowired
   public void setProjectService(ProjectService projectService) {
    this.projectService = projectService;
  }
}

