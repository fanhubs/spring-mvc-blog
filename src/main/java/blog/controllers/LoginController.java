package blog.controllers;

import blog.forms.LoginForm;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;

/**
 * Created by qiang on 18-7-7.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    //@RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            notificationService.addErrorMessage("please fill the form correctly");
            return "users/login";
        }
        if(!userService.authenticate(
                loginForm.getUsername(),loginForm.getPassword())){

            notificationService.addErrorMessage("inalid login");
            return "users/login";

        }

        notificationService.addInforMessage("login successful");
        return "redirect:/";
    }

    @GetMapping(value = "/users/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/users/login");
        return mav;
    }

}
