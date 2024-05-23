package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.entities.User;
import com.smart.forms.UserForm;
import com.smart.services.UserServices;


@Controller
public class pageContoller {

	@Autowired
	private UserServices userService;
	
	
	@GetMapping("/home")
	public String Home() {
		return "home";
	}

	@GetMapping("/about")
	public String About() {
		return "about";

	}

	@GetMapping("/services")
	public String Services() {
		return "services";
	}

	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	@GetMapping("/register")
	public String Register(Model model) {
		UserForm userForm = new UserForm();
		// Example of setting an attribute
//		userForm.setName("Rohit Yadav");
		model.addAttribute("userForm", userForm);
		return "register";
	}

	@GetMapping("/contact")
	public String Contact() {
		return "contact";
	}
	// processing register

	@PostMapping("/do-register")
	public String processRegister(@ModelAttribute UserForm userForm) {

		// fetch form data
        System.out.println(userForm);
		// validate from data

		// save to database
        //userservice

//        User user =User.builder()
//        	.name(userForm.getName())
//        	.email(userForm.getEmail())
//        	.password(userForm.getPassword())
//        	.about(userForm.getAbout())
//        	.phoneNumber(userForm.getPhoneNumber())
//        	.profilePic("https://media.istockphoto.com/id/1332100919/vector/man-icon-black-icon-person-symbol.jpg?s=1024x1024&w=is&k=20&c=3tq1Z6hSIBaqB7XIFbvi2PAWnDz4zjHI64RhGJOQON4=")
//        		.build();
        
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://media.istockphoto.com/id/1332100919/vector/man-icon-black-icon-person-symbol.jpg?s=1024x1024&w=is&k=20&c=3tq1Z6hSIBaqB7XIFbvi2PAWnDz4zjHI64RhGJOQON4=");
        
        
        userService.saveUser(user);
		// message="registration Successfully"
        System.out.println("user Saved");
		// redirect to login page
		return "redirect:/register";
	}
}
