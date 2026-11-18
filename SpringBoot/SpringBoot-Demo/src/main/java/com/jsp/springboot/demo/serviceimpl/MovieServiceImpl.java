package com.jsp.springboot.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot.demo.entity.Movie;
import com.jsp.springboot.demo.repository.MovieRepository;
import com.jsp.springboot.demo.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public String addMovie(Movie movie) {
		movieRepository.save(movie);
		
		return "Movie added successfully!!";
	}
	
}
