package com.me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.entity.User;
import com.me.form.UserForm;
import com.me.message.Message;
import com.me.message.MessageType;
import com.me.service.UserService;

import jakarta.servlet.http.HttpSession;

 

@Controller
public class PagesController {

    @Autowired
    private UserService service;

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "Infosys Technologies");
        model.addAttribute("YoutubeChannel", "code with Rahul");
        model.addAttribute("Github", "https://github.com/VSrihub");
        System.out.println("home page");

        return "home";
        
    }

    @RequestMapping("/about")
    public String about(){
        System.out.println("ABout");
        return "about";
    }

    @RequestMapping("/service")
    public String service(){
        System.out.println("service");
        return "service";
    }

    @GetMapping("/contact")
    public String contact( ){
        System.out.println("contact");
        return new String("contact");
    }

    @GetMapping("/login")
    public String login( ){
        System.out.println("login");
        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model){
        UserForm userForm= new UserForm();
model.addAttribute("userForm", userForm);

        //System.out.println("register");
       return  "register";
    }
    
    //processing register
     @RequestMapping(value = "/do-register",method = RequestMethod.POST)
public String processRegister(@ModelAttribute UserForm userForm,HttpSession session){

    //save user to db
    //userfrom convert to user
    ///User user=User.builder()
    //.name(userForm.getName())
    //.email(userForm.getEmail())
    //.password(userForm.getPassword())
    //.about(userForm.getAbout())
    //.phoneNumber(userForm.getPhoneNumber())
//.ProfilePic("D:\\Contact\\Contact-App\\src\\main\\resources\\static\\image\\profile.jpg")
   // .build();

   User users = new User();
   users.setName(userForm.getName());
       users.setEmail(userForm.getEmail());
       users.setAbout(userForm.getAbout());
       users.setPassword(userForm.getPassword());
       users.setPhoneNumber(userForm.getPhoneNumber());
       users.setProfilePic("D:\\\\Contact\\\\Contact-App\\\\src\\\\main\\\\resources\\\\static\\\\image\\\\profile.jpg");
        
    User saveUser =service.saveUser(users);
    Message message=Message.builder().content("Registration Sucessful").
    type(MessageType.green).build();
session.setAttribute("message",message);
    return "redirect:/register";
}


}
