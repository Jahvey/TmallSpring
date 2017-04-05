package xyz.ivyxjc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jc on 4/3/2017.
 */


@Controller
public class LoginController {

    @RequestMapping(method = RequestMethod.GET,value = "/login")
    public String show(){
        return "front/login";
    }

    @RequestMapping(method = RequestMethod.POST,value="/forelogin")
    public String onSubmit(
            @RequestParam("name")String username,
            @RequestParam("password")String password,
            Model model){

        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try{
            SecurityUtils.getSubject().login(token);
        }catch (AuthenticationException e){
            model.addAttribute("errorInvalidLogin", "The username or password was not correct.");
            return "front/login";
        }
        return "redirect:/";
    }
}
