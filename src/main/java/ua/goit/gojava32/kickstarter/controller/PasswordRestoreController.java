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

import javax.servlet.http.HttpServletRequest;

@Controller
public class PasswordRestoreController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/forgot_password", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView redirect() {
        ModelAndView vm = new ModelAndView("forgot_password");
        return vm;
    }

    @RequestMapping(value = "/search_by_email_page", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView search( HttpServletRequest request,
            @RequestParam("search_mail") String searchMail) {
        String domain = request.getRequestURL().toString();
        domain = domain.substring(0, domain.length() - 21);
        ModelAndView vm = new ModelAndView("search_by_email_page");
        User user = userService.findUserByEmail(searchMail);
        if (user != null){
            vm.addObject("result_search", "Check you e-mail for reset you password");
            String username = user.getUsername();
            String md5password = DigestUtils.md5Hex(user.getPassword());
            SendMail.send(searchMail, "press link below for restore password " + username, domain + "/restore?token=" + md5password + "&email=" + searchMail);
        } else {
            vm.addObject("result_search", "Can't find that email, sorry.");
        }
        return vm;
    }

    @RequestMapping(value = "/restore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView restore(@RequestParam("email") String email, @RequestParam("token") String token){

        User user = userService.findUserByEmail(email);
        ModelAndView vm;
        String md5password = DigestUtils.md5Hex(user.getPassword());
        if (user != null && md5password.equals(token)){
            vm = new ModelAndView("restore_password");
            vm.addObject("token",token);
            vm.addObject("email",email);
        } else {
            vm = new ModelAndView("error_page");
        }
        return vm;
    }

    @RequestMapping(value = "/update_password", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView updatePassword(@RequestParam("password") String password,
                                       @RequestParam("password2") String password2,
                                       @RequestParam("token") String token,
                                       @RequestParam("email") String email){
        ModelAndView vm;
        if (password.equals(password2)) {
            User user = userService.findUserByEmail(email);
            if (user != null && DigestUtils.md5Hex(user.getPassword()).equals(token)){
                user.setPassword(DigestUtils.md5Hex(password2));
                userService.update(user);
                vm = new ModelAndView("login_page");
            } else {
                vm = new ModelAndView("error_page");
            }
        } else {
            vm = new ModelAndView("error_page");
        }
        return vm;
    }

}
