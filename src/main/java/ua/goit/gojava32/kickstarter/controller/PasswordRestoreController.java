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
        ModelAndView vm = new ModelAndView("search_by_email_page");
        User findUser = userService.findUserByEmail(searchMail);
        if (findUser == null){
            vm.addObject("result_search", "Can't find that email, sorry.");
        } else {
            vm.addObject("result_search", "Check you e-mail for reset you password");
            String username = findUser.getUsername();
            String md5password = DigestUtils.md5Hex(findUser.getPassword());
            SendMail.send(searchMail, "press link below for restore password " + username, domain + "/restore?token=" + md5password + "&email=" + searchMail);
        }
        return vm;
    }


}
