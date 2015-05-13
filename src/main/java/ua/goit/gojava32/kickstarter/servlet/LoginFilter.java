package ua.goit.gojava32.kickstarter.servlet;

import org.apache.log4j.Logger;
import ua.goit.gojava32.kickstarter.factory.FactoryDB;
import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.model.User;
import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter{
  private final String TOKEN = "token";
  private Logger logger = Logger.getLogger(this.getClass());

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = ((HttpServletRequest) req);
    String Uri = request.getRequestURI();
    logger.info("filter login: " + Uri);
    long startTime = System.currentTimeMillis();

//    doFilterCookie(req);
    chain.doFilter(req, resp);

    logger.info("duration: " + Uri + " " + (System.currentTimeMillis() - startTime) + " ms.");

  }

  private void doFilterCookie(ServletRequest req) {

//    Cookie[] cookies = ((HttpServletRequest)req).getCookies();
//    if (cookies != null) {
//      for (Cookie cookie : cookies) {
//        if (cookie.getName().equals(TOKEN)) {
//          User user = ServiceModel.getUserService().findUserByToken(cookie.getValue());
//          req.setAttribute("user", user);
//          break;
//        }
//      }
//    }

  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    FactoryDB.createDB();
  }

}
