package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.ProjectService;


@Controller
public class CategoryController {


  public CategoryController() {
  }
  @Autowired
  CategoryService categoryService;
  @Autowired
  ProjectService projectService;

  @RequestMapping(method = RequestMethod.POST, value = "/category")
  public ModelAndView addCategory(
      @RequestParam("category_name") String categoryName,
      @RequestParam("category_description") String description) {

    categoryService.add(categoryName, description);
    ModelAndView vm = new ModelAndView("redirect:/categories");
    return vm;
  }


  @RequestMapping(method = RequestMethod.GET, value = "/category")
  public ModelAndView listAllCategories(){


    ModelAndView vm = new ModelAndView("categories.jsp");
    vm.addObject("categories", categoryService.findAll());
    return vm;
  }



  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

   public void setProjectService(ProjectService projectService) {
    this.projectService = projectService;
  }
}

