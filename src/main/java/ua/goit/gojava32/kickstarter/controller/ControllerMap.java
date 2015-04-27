package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.servlet.Request;

import java.util.HashMap;
import java.util.Map;

public class ControllerMap {

  private static Map<Request,Controller> controllerMap = new HashMap<Request,Controller>(){
    {
      put(Request.create("get", "addCategory"), new ControllerAddCategory());
      put(Request.create("get", "addProject"), new ControllerAddProject());
      put(Request.create("get", "addProjectComment"), new ControllerAddProjectComment());
      put(Request.create("get", "addProjectBlog"), new ControllerAddProjectBlog());
      put(Request.create("get", "login_page"), new ControllerLogin());
      put(Request.create("get", "registration_page"), new ControllerRegister());
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
