package com.example.ninjagold.controlllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private Random rand;
	
	@RequestMapping("/")
	private String index(HttpSession session) {
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold",0);
			session.setAttribute("res","");
		}
		
		return "index.jsp";
	}

@RequestMapping(path="/process/{id}",method=RequestMethod.POST)
public String process(@PathVariable int id,HttpSession session){
		rand       = new Random();
		int gold   = 0;
		String res = "You entered a";
		
	switch(id) {
		case 1:
			gold = rand.nextInt(10)+10;
			res = "Farm and earned " +gold+ "gold";
			break;
		
		case 2:
			gold =rand.nextInt(5)+5;
			res = " Cave and earned" +gold+ "gold";
			break;
		case 3:
			gold = rand.nextInt(3)+2;
			res = "House and earned " +gold+ "gold";
			break;
		case 4: 
			gold = rand.nextInt(100)-50;
			if(gold < 0) {
				res = " casino and lost " +gold+ "gold";
				
			}else {
				res = "casino and earned " +gold+ "gold";
			}
			break;
	}
	session.setAttribute("gold",(Integer) session.getAttribute("gold")+gold);
	session.setAttribute("res",(String) session.getAttribute("res")+res+"\n");
	
	return "redirect:/";
	
}
}
