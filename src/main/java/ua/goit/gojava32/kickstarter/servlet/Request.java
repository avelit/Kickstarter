package ua.goit.gojava32.kickstarter.servlet;

import ua.goit.gojava32.kickstarter.service.CategoryService;
import ua.goit.gojava32.kickstarter.service.CategoryServiceImpl;
import ua.goit.gojava32.kickstarter.service.ProjectService;
import ua.goit.gojava32.kickstarter.service.ProjectServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Request {
  String method;
  String URI;
  String lastSegment;
  Map<String,String> parameters = new HashMap<>();
  public CategoryService categoryService = new CategoryServiceImpl();
  public ProjectService projectService = new ProjectServiceImpl();

  public Request(String method, String URI, Map<String, String> parameters) {
    this.method = method;
    this.URI = URI;
    String[] segments = URI.split("/");
    this.lastSegment = segments[segments.length - 1];
    this.parameters = parameters;
  }

  public static Request create(String method, String URI){
    return new Request(method,URI,null);
  }

  public String getLastSegment() {
    return lastSegment;
  }

  public String getURI() {
    return URI;
  }

  public void setURI(String URI) {
    this.URI = URI;
  }

  public String getMethod() {
    return method;
  }

  public Map<String, String> getParameters() {
    return parameters;
  }

  public void addParameter(String key, String value) {
    this.parameters.put(key, value);
  }

  public String getParameter(String key) {
    return parameters.get(key);
  }
}
