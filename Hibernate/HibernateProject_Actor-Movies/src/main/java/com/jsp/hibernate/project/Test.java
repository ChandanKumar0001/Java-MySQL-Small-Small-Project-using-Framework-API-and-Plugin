package com.jsp.hibernate.project;

import com.jsp.hibernate.actor_movies.dao.MovieDao;

public class Test {
public static void main(String[] args) {
	
	MovieDao m = new MovieDao();
	m.updateMovieVerdictBetweenCollection();
}
}
