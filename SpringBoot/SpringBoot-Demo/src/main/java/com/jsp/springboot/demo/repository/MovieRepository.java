package com.jsp.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot.demo.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	//save()
	//findById()
	//findAll()
	//delete()
	//deleteById()
	
}
