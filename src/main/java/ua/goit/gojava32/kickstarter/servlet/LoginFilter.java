package ua.goit.gojava32.kickstarter.servlet;

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
    Cookie[] cookies = ((HttpServletRequest)req).getCookies();
    for (int i = 0; i < cookies.length; i++) {
      if (cookies[i].getName().equals(TOKEN)){
        User user = (new UserServiceImpl()).findUserByToken(cookies[i].getValue());
        req.setAttribute("user", user);
        break;
      }
    }
    chain.doFilter(req, resp);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
  }

}
