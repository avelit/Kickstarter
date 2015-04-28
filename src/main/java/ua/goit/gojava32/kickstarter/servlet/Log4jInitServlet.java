package ua.goit.gojava32.kickstarter.servlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;

public class Log4jInitServlet extends HttpServlet {

  public void init() {
    String prefix =  getServletContext().getRealPath("/");
    String file = getInitParameter("log4j-init-file");
    if(file != null) {
      PropertyConfigurator.configure(prefix + file);
    }
  }

  private static final long serialVersionUID = 1L;

  /*public void init(ServletConfig config) throws ServletException {
    System.out.println("Log4JInitServlet is initializing log4j");
    String log4jLocation = config.getInitParameter("log4j-properties-location");

    ServletContext sc = config.getServletContext();

    if (log4jLocation == null) {
      System.err.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
      BasicConfigurator.configure();
    } else {
      String webAppPath = sc.getRealPath("/");
      String log4jProp = webAppPath + log4jLocation;
      File propFile = new File(log4jProp);
      if (propFile.exists()) {
        PropertyConfigurator.configure(log4jProp);
      } else {
        System.err.println("*** " + log4jProp + " file not found, initializing log4j with BasicConfigurator");
        BasicConfigurator.configure();
      }
    }
    super.init(config);
  }*/
}
