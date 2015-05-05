package ua.goit.gojava32.kickstarter.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import ua.goit.gojava32.kickstarter.factory.ServiceModel;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.SendMail;
import ua.goit.gojava32.kickstarter.service.UserService;
import ua.goit.gojava32.kickstarter.view.ViewModel;
import javax.servlet.http.HttpServletRequest;

public class ControllerRegister implements Controller {
  @Override
  public ViewModel process(HttpServletRequest request) {
    final Logger logger = Logger.getLogger(ControllerRegister.class);

    UserService userService = ServiceModel.getUserService();

    String name = request.getParameter("name");
    String pass = request.getParameter("password");
    String email =  request.getParameter("email");
    String token = DigestUtils.md5Hex(email + ":" + pass);

    User user = userService.findUserByEmail(email);
    if (user == null) {
      userService.add(name, token, email, false);
      String domain = request.getRequestURL().toString();
      domain = domain.substring(0, domain.length() - 13);///registration
      SendMail.send(email, "press link below for activating " + name, domain + "/activate?token=" + token);

      logger.info("Activating user " + email);
      return new ViewModel("/categories", "sendRedirect", null);
    }
    request.setAttribute("text_failed", "User with email " + email + " exist.");
    return new ViewModel("/jsp/registration.jsp", "forward", null);
  }
}
