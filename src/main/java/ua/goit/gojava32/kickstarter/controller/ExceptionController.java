package ua.goit.gojava32.kickstarter.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
  @ExceptionHandler(Exception.class)
  public ModelAndView exceptionHandler(Exception ex) {
    return new ModelAndView("error_page", "error_name", ex.getMessage());
  }
}
