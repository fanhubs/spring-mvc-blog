package blog.controllers;

import blog.forms.RegisterForm;
import blog.models.User;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by qiang on 18-7-8.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String createUser(@Valid RegisterForm registerForm, BindingResult bindingResult){

        //check if this user name is existing in the db
        if(userService.existUserName(registerForm.getUsername()))
            return "redirect:/users/register";
        // add this user into db if not existing
        User user = new User();
        user.setFullName(registerForm.getUsername());
        user.setName(registerForm.getUsername());
        user.setPassword_hash(registerForm.getPassword());
        userService.create(user);
        return "/users/register";
    }

    @RequestMapping(value = "/users/register")
    public String register(RegisterForm registerForm){
        return "/users/register";
    }
}
