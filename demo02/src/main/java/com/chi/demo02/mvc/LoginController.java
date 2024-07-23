package com.chi.demo02.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // 設定 Session 屬性
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }


    // @RequestMapping("/login")
    // public String login() {
    //     return "login";
    // }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    // without authentication
    // @RequestMapping(value="/login", method = RequestMethod.POST)
    // public String doLoginV1(@RequestParam String name, @RequestParam String password, ModelMap model) {
    //     model.put("name", name);
    //     model.put("password", password);
    //     return "home";
    // }

    // with authentication
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String doLoginV2(@RequestParam String name, @RequestParam String password, Model model) {

        if(this.authenticationService.authenticate(name, password)) {
            model.addAttribute("name", name);
            return "home";
        }
        model.addAttribute("errorMessage", "無效的帳號或密碼");
        return "login";
    }
}
