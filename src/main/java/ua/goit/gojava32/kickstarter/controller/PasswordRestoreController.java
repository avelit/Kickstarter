package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.User;
import ua.goit.gojava32.kickstarter.service.UserService;

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
    public ModelAndView search(@RequestParam("search_mail") String searchMail) {
        ModelAndView vm = new ModelAndView("search_by_email_page");
        User findUser = userService.findUserByEmail(searchMail);
        if (findUser == null){
            vm.addObject("result_search", "Can't find that email, sorry.");
        } else {
            vm.addObject("result_search", "Check you e-mail for reset you password");
        }
        return vm;
    }
}
