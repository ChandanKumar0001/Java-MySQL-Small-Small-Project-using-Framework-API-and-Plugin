package com.jsp.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.springboot.demo.entity.Movie;
import com.jsp.springboot.demo.service.MovieService;

@Controller
@ResponseBody
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	//movieService ms = new MovieServiceImpl();
	
	public String addMovie(Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String print() {
		return "Learning Spring Boot";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public int add(int n1, int n2) {
		return n1 + n2;
	}
}
