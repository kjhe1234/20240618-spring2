package com.kjhe1234.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KeywordController {
	
	@RequestMapping(value = "/keyword")
	public String keyword() {
		return "keyword";
	}
	
	@RequestMapping(value = "/keywordOk")
	public String keywordOk(HttpServletRequest request) {
		
		String keyword = request.getParameter("keyword");
		
		if(keyword.equals("abc")) {
			return "redirect:keywordGood";
			//return "keywordGood"
			
		} else {
			return "redirect:keywordBad";
			//return "keywordBad"
			
		}
		
	}
	
	
	@RequestMapping(value = "/keywordBad")
	public String keywordBad(Model model) {
		
		model.addAttribute("keyword","xxx");
		
		return "keywordBad";
	}
	
	@RequestMapping(value = "/keywordGood")
	public String keywordGood(Model model) {
		
		model.addAttribute("keyword","xxx");
		
		return "keywordGood";
	}
	
	
	
}
