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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView login(){
    return new ModelAndView("login_page");
  }


  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView login(HttpServletResponse response,
                            @RequestParam("email") String email,
                            @RequestParam("password") String password) {

    String token = DigestUtils.md5Hex(email + ":" + password);
    User user = userService.findUserByToken(token);

    ModelAndView vm;
    if (user == null || !user.isActive()) {
      vm = new ModelAndView("redirect:/login_page");
      vm.addObject("text_failed", "Wrong user or password or user not active.");
    } else {
      vm = new ModelAndView("redirect:/category");
      vm.addObject("user", user);
      response.addCookie(new Cookie("token", token));
    }
    return vm;
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView logout(HttpServletResponse response) {

    ModelAndView vm = new ModelAndView("redirect:/category");
    response.addCookie(new Cookie("token", ""));
    return vm;
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView registration(HttpServletRequest request,
                               @RequestParam("name") String name,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password) {

    String token = DigestUtils.md5Hex(email + ":" + password);

    User user = userService.findUserByEmail(email);
    ModelAndView vm;
    vm = new ModelAndView("registration");
    if (user == null) {
      user = new User();
      user.setName(name);
      user.setEmail(email);
      user.setToken(token);
      userService.add(user);
      String domain = request.getRequestURL().toString();
      domain = domain.substring(0, domain.length() - 13);///registration
      SendMail.send(email, "press link below for activating " + name, domain + "/activate?token=" + token);
      vm.addObject("text_failed", "Check you mail for activating.");
    } else {
      vm.addObject("text_failed", "User with email " + email + " exist.");
    }
    return vm;
  }

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView registration(){
    return new ModelAndView("registration");


  }

  @RequestMapping(value = "/activate", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView activate(HttpServletResponse response,@RequestParam("token") String token){

    User user = userService.findUserByToken(token);
    ModelAndView vm = new ModelAndView("redirect:/category");
    if (user != null){
      user.setIsActive(true);
      userService.update(user);
      vm.addObject("user", user);

      response.addCookie(new Cookie("token", token));
    }
    return vm;
  }

  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView profile(HttpServletRequest request){
    User user = (User) request.getAttribute("user");
    ModelAndView mv =new ModelAndView("user_profile");
    mv.addObject("user_name", user.getName());
    return mv;
  }
}

