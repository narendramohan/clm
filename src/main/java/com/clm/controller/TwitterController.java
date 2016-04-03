package com.clm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clm.entities.Message;
import com.clm.entities.Topic;
import com.clm.entities.User;
import com.clm.services.MessageService; 
import com.clm.services.TopicService;
import com.clm.services.UserService;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Controller
public class TwitterController {
	@Autowired
	TopicService topicService;
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/twitter")
	public String twitter(Model model)
	{
		model.addAttribute("user", getPrincipal());
		return "twitter";
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
	@RequestMapping("/twits")
	public String twits(Model model) {
		Properties props = null;
		try {
			//twitter.customer.key=ATflJJwtDEL56UBkwUv2JGGQd
			//twitter.customer.secret=85UM6fASxvWQ6CUQ1G9WAjDlpcRFi0Dqn3u7Bua6YNdvHOrOXB
			//		twitter.accesstoken=80365108-CjxofehDk1BF9JpNC4kP2oFRR0f85VHURubKs4iDu
			//		twitter.accesstoken.secret=AvcUXwiod9hMzzvORO5RhBfnihxJdEJDmNQie7t50FCQm 
			//
			props = PropertiesLoaderUtils.loadAllProperties("application.properties");
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setOAuthConsumerKey(props.getProperty("twitter.customer.key"));
			cb.setOAuthConsumerSecret(props.getProperty("twitter.customer.secret"));
			cb.setOAuthAccessToken(props.getProperty("twitter.accesstoken"));
			cb.setOAuthAccessTokenSecret(props.getProperty("twitter.accesstoken.secret")); 
			// Create Twitter instance
			Twitter twitter = new TwitterFactory(cb.build()).getInstance();
			// Create Query object and set search string
			Query query = new Query("");
			List<Topic> topics = topicService.findAll();
			int counter =0; 
			Message m=null;
			List<Message> ms = new ArrayList<>();
			for(Topic t:topics){
				counter =0;
				// Get query result
				query.setQuery("#"+t.getName());
				QueryResult qr = twitter.search(query);
				// Get tweets and write in the file
				
				while (qr.hasNext()) {
					qr.nextQuery();
					List<Status> tweets = qr.getTweets();
					for (Status s : tweets) {
						m=new Message();
						m.setId(UUID.randomUUID().toString());
						m.setTopic(t.getName());
						m.setMessage(s.getText());
						ms.add(m);
						System.out.println(s.getId() + " - " + s.getCreatedAt() + ": " + s.getText());
						/*out.write("\n" + t.getId() + ",");
						out.write("\t" + t.getText() + ",");
						out.write("\t" + t.getUser() + ",");*/
					}
					if(counter==10)
						break;
					else
						counter++;
				}
				
			}
			messageService.deleteMessages();
			messageService.saveAllMessage(ms);
			model.addAttribute("user", getPrincipal());
			model.addAttribute("ms", ms);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "twitter";

	}

}
