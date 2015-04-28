package ua.goit.gojava32.kickstarter.view;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class ViewModel {
  private String view;
  private String command;
  private Map<String,Object> atributes = new HashMap<>();
  private Cookie newCookie;

  public ViewModel(String view, String command, Map<String, Object> atributes) {
    this.view = view;
    this.command = command;
    this.atributes = atributes;
  }

  public String getView() {
    return view;
  }

  public void setView(String view) {
    this.view = view;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Map<String, Object> getAtributes() {
    return atributes;
  }

  public void addAtribute(String key, Object value) {
    this.atributes.put(key,value);
  }

  public void addCookie(Cookie newCookie) {
    this.newCookie = newCookie;
  }

  public Cookie getNewCookie() {
    return newCookie;
  }
}
