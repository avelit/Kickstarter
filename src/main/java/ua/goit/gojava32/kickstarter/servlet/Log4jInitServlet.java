package ua.goit.gojava32.kickstarter.servlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;

public class Log4jInitServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void init() {
    String prefix =  getServletContext().getRealPath("/");
    String file = getInitParameter("log4j-init-file");
    if(file != null) {
      PropertyConfigurator.configure(prefix + file);
    }
  }
}
