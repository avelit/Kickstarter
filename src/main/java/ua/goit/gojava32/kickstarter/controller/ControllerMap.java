package ua.goit.gojava32.kickstarter.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerMap {
  Map<String,Controller> controllerMap = new HashMap<String,Controller>(){
    {
      put("/addProject",new ControllerAddProject());
    }
  };

  public Controller getController(String command){
    return controllerMap.get(command);
  }
}
