package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.servlet.Request;

import java.util.HashMap;
import java.util.Map;

public class ControllerMap {

  private static Map<Request,Controller> controllerMap = new HashMap<Request,Controller>(){
    {
      put(Request.create("post", "addCategory"), new ControllerAddCategory());
      put(Request.create("post", "addProject"), new ControllerAddProject());
      put(Request.create("post", "addProjectComment"), new ControllerAddProjectComment());
      put(Request.create("post", "addProjectBlog"), new ControllerAddProjectBlog());
      put(Request.create("post", "login_page"), new ControllerLogin());
      put(Request.create("post", "registration_page"), new ControllerRegister());
      put(Request.create("get", "categories"), new ControllerCommon());
    }
  };

  public static Controller getController(Request request) {
    Controller controller = controllerMap.get(request);
    if (controller == null){
      controller = new ControllerCommon();
    }
    return controller;
  }

}
