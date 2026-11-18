package com.jsp.spring_mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	
	@RequestMapping("/example")
	public ModelAndView print(int userId, String userName) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("output.jsp");
		mav.addObject("key1", userId);
		mav.addObject("key2",userName);
		
		return mav;
	}
}
