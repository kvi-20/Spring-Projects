//package com.example.web_app.login;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class LoginController {
//
//    private AuthenticationService authenticationService;
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
////    Logger logger = LoggerFactory.getLogger(this.getClass());
////    @RequestMapping("login")
////    public String login(@RequestParam String name, ModelMap model){
////        model.put("name",name);
////        logger.info("Request Param is "+ name);
////        return "login";
////    }
//
//    @RequestMapping(value="login",method= RequestMethod.GET)
//    public String goToLogin(){
//        return "login";
//    }
//
//    @RequestMapping(value="login",method= RequestMethod.POST)
//    public String goToWelcome(@RequestParam String name, @RequestParam String password, ModelMap model){
//        if(authenticationService.authenticate(name,password)) {
//            model.put("name",name);
//            return "welcome";
//        }
//        model.put("errorMessage","Invalid credentials. Please enter valid input");
//        return "login";
//    }
//}
