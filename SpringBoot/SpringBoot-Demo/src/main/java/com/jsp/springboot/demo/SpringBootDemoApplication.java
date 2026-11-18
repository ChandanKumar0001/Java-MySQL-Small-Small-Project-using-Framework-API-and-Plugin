package com.jsp.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jsp.springboot.demo.controller.MovieController;
import com.jsp.springboot.demo.entity.Movie;

@SpringBootApplication
//Above annotations are the combinations of below three annotations
//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		//1. Create the Spring bean Container
		//2. To read the CoSnfiguration file
		//3. Hit the same class because of the Parameter and recognize the annotation
		
		//for postman testing we have to comment this below previous code
//		ApplicationContext ac = SpringApplication.run(SpringBootDemoApplication.class, args);
//		
//		Movie movie = new Movie();
//		movie.setMovieId(101);
//		movie.setTitle("Chaava");
//		movie.setGenre("Biopic");
//		movie.setDirector("No-idea");
//		movie.setVerdict("Blockbuster");
//		
//		MovieController movieController=ac.getBean(MovieController.class);
//		movieController.addMovie(movie);
//		
		ApplicationContext ac = SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
