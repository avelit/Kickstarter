package ua.goit.gojava32.kickstarter.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerMap {

  private static Map<String,Controller> controllerMap = new HashMap<String,Controller>(){
    {
      put("/addProject", new ControllerAddProject());
      put("/addCategory", null);
      put("/addProjectComment", null);
      put("/", null);
      put("/login_page", null);
      put("/registration_page", null);
    }
  };

  public static Controller getController(String requestURL) {
    return controllerMap.get(requestURL);
  }

}
