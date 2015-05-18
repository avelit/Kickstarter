package ua.goit.gojava32.kickstarter.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.SendMail;
import ua.goit.gojava32.kickstarter.service.UserService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = {"/login","/login_page"}, method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView login(){
    return new ModelAndView("login_page");
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView registration(HttpServletRequest request,
                               @RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password) {

    String md5password = DigestUtils.md5Hex(password);

    User user = userService.findUserByEmail(email);
    ModelAndView vm;

    if (user == null) {
      user = new User();
      user.setName(name);
      user.setEmail(email);
      user.setPassword(md5password);
      userService.add(user);

//      String domain = request.getRequestURL().toString();
//      domain = domain.substring(0, domain.length() - 13);///registration
//      SendMail.send(email, "press link below for activating " + name, domain + "/activate?token=" + token);
//      vm.addObject("text_failed", "Check you mail for activating.");
      vm = new ModelAndView("redirect:/login");
    } else {
      vm = new ModelAndView("registration");
      vm.addObject("text_failed", "User with email " + email + " exist.");
    }
    return vm;
  }

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView registration(){
    return new ModelAndView("registration");
  }

//  @RequestMapping(value = "/activate", method = RequestMethod.GET)
//  @ResponseBody
//  public ModelAndView activate(HttpServletResponse response,@RequestParam("token") String token){
//
//    User user = userService.findUserByToken(token);
//    ModelAndView vm = new ModelAndView("redirect:/category");
//    if (user != null){
////      user.setIsActive(true);
////      userService.update(user);
////      vm.addObject("user", user);
////
////      response.addCookie(new Cookie("token", token));
//    }
//    return vm;
//  }

  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView profile(HttpServletRequest request, Principal principal){
    ModelAndView mv = new ModelAndView("user_profile");
    mv.addObject("user_name", principal.getName());
    return mv;
  }
}

