package com.clm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.clm.entities.Topic;
import com.clm.entities.User;
import com.clm.services.TopicService;
import com.clm.services.UserService;

/*
 * As per the paper currently considering following Topics 
Apple 
Jared Allen 
Bin Laden
Eyedea 
Herman Cain 
Diddy Dirty Money
Green Bay 
Sidney Poitier 
The Dark Knight
Black Friday 
Amazing Grace 
Fox News Channel
Bloom Box 
Aretha Franklin 
Sugarloaf Mountain
Bill T Jones 
Anjelah Johnson 
Teddy Pendergrass
Total Eclipse 
Russian National Anthem
Merle Haggard 
Giants Stadium Demolition
Family Watch Dog Sue Sylvester Vogue
New York Giants 
National Economic Council
Victoria Beckham 
Kennedy Center Honors
Pro Bowl 
West Memphis Three
 */
@Controller
@SessionAttributes("roles")
public class TopicController {
	@Autowired
	TopicService topicService;
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = {"admin/topics" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		List<Topic> topics = topicService.findAll();
		System.out.println(topics);
		model.addAttribute("topics", topics);
		return "topics";
	}
	
	@Autowired
	UserService userService;
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		User user = userService.findUserByEmail(userName);
		String name = user.getFirstName()+" "+user.getLastName();
		return name;
	}

}
