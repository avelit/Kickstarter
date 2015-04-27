package ua.goit.gojava32.kickstarter.controller;

import ua.goit.gojava32.kickstarter.servlet.Request;
import ua.goit.gojava32.kickstarter.view.ViewModel;

import java.io.IOException;

public interface Controller {
  public ViewModel process(Request request);
}
