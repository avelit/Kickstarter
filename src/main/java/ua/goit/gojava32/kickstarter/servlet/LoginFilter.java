package ua.goit.gojava32.kickstarter.servlet;

import ua.goit.gojava32.kickstarter.factory.FactoryDB;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.UserServiceImpl;
import java.io.IOException;
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

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    doFilterCookie(req);
    chain.doFilter(req, resp);
  }

  private void doFilterCookie(ServletRequest req) {
    Cookie[] cookies = ((HttpServletRequest)req).getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals(TOKEN)) {
          User user = (new UserServiceImpl()).findUserByToken(cookie.getValue());
          req.setAttribute("user", user);
          break;
        }
      }
    }
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
