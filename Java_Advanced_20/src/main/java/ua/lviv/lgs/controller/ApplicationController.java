package ua.lviv.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.lviv.lgs.model.User;
import ua.lviv.lgs.services.UserService;

@Controller
public class ApplicationController  {
	
	@Autowired
	private UserService userSerivce;

	//Start
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start(HttpServletRequest request) {
		
		System.out.println(userSerivce.findByUserName("denys"));
		
		return "EllenPage";
	}
	
	//
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
			
		return "login";
	}
	
	//
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request) {
			
		return "register";
	}
	
	//
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(HttpServletRequest request) {
		
		System.out.println("Oi");
		
		User user = new User();
		
		user.setUserName(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role").toUpperCase());
		
		userSerivce.create(user);
		
		return "login";
	}
	
	//
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest request) {
			
		return "admin";
	}
	
		
	
	
}
