package ua.goit.gojava32.kickstarter.servlet;

import org.apache.log4j.Logger;
import ua.goit.gojava32.kickstarter.controller.Controller;
import ua.goit.gojava32.kickstarter.controller.ControllerMap;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ErrorFilter implements Filter{
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest req = ((HttpServletRequest) request);
    String Uri = req.getRequestURI();
    Logger logger = Logger.getLogger(this.getClass());
    logger.info("filter error: " + Uri);

    String[] uriSegments = Uri.split("/");
    Controller controller = ControllerMap.getController(req.getMethod().toLowerCase() + "_" + uriSegments[uriSegments.length - 1]);

    if (controller == null) {
      request.setAttribute("error_code", "");
      request.getRequestDispatcher("/error").forward(request, response);
    }

    filterChain.doFilter(request, response);

  }

  @Override
  public void destroy() {

  }
}
