package ua.goit.gojava32.kickstarter.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerMap {

  private static Map<String, Controller> controllerMap = new HashMap<String, Controller>() {
    {
      put("post_addCategory", new ControllerAddCategory());
      put("post_addProject", new ControllerAddProject());
      put("post_addProjectComment", new ControllerAddProjectComment());
      put("post_addProjectBlog", new ControllerAddProjectBlog());
      put("get_registration_page", new ControllerRegisterPage());
      put("get_login_page", new ControllerLoginPage());
      put("post_registration", new ControllerRegister());
      put("post_login", new ControllerLogin());
      put("get_categories", new ControllerCommon());
      put("get_activate", new ControllerUserActivate());
    }
  };

  public static Controller getController(String request) {

    Controller controller = controllerMap.get(request);
    if (controller == null) {
      controller = new ControllerCommon();
    }
    return controller;
  }

}
