package com.clm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clm.entities.Message;
import com.clm.mmm.SyntacticDecomposition;
import com.clm.services.MessageService;

import facebook4j.internal.logging.Logger;

@Controller
public class StatisticsController {
	@Autowired
	private MessageService messageService;
	
	@RequestMapping("/statics")
	public String getStatics(Model model){
		List<Message> messages= messageService.findAll();
		model.addAttribute("noofMessages", messages.size());
		model.addAttribute("noofClusters", 150);
		Set<String> uString = new HashSet<>();
		List<String> msgs = new ArrayList<>();
		int avgLen=0;
		int c=0;
		SyntacticDecomposition sd = new SyntacticDecomposition();
		
		int avgcs = 0;
		for(Message m:messages){
			String msg = m.getTopic();
			String[] s = msg.replaceAll("[^A-Za-z0-9]", "").split(" ");
			uString.addAll(Arrays.asList(s));
			c++;
			avgLen+=msg.length();
			msgs.add(msg);
			
		}
		int ss=0;
		try {
			ss = sd.createTreeFragment(msgs).size();
		} catch(Exception e){
			ss=100;
			Logger.getLogger(this.getClass()).debug(e.getMessage());
		}
		avgLen=avgLen/c;
		model.addAttribute("noofuniquewords", uString.size());
		model.addAttribute("avgMsgLen",avgLen);
		model.addAttribute("maxClustersize", ss);
		return "statics";
	}
}
