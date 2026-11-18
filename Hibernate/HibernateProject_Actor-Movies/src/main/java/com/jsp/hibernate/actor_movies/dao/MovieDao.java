package com.jsp.hibernate.actor_movies.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jsp.hibernate.actor_movies.entity.Actor;
import com.jsp.hibernate.actor_movies.entity.Movie;

public class MovieDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	Scanner s = new Scanner(System.in);

	public void addMovie() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		System.out.println("enter new movie id");
		Movie m = new Movie();
		m.setMovieId(s.nextInt());

		System.out.println("enter movie name");
		m.setTitle(s.next());

		System.out.println("enter director");
		m.setDirector(s.next());

		System.out.println("enter genre");
		m.setGenre(s.next());

		System.out.println("enter verdict");
		m.setVerdict(s.next());

		System.out.println("enter collection");
		m.setCollection(s.nextInt());

		System.out.println("--------------------");

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
		Root<Actor> root = cq.from(Actor.class);
		Query query = em.createQuery(cq);
		List<Actor> actors = query.getResultList();

		if (actors == null) {
			System.err.println("no actos found");
		} else {
			for (Actor actor : actors) {
				System.out.println(actor);
			}
		}

		System.out.println("enter actors ids to add to the movie");
		String actorlist = s.next();

		String[] actorlst = actorlist.split(",");
		int[] actorid = new int[actorlst.length];
		List<Actor> actorsListMov = new ArrayList<Actor>();
		for (int i = 0; i < actorlst.length; i++) {
			actorid[i] = Integer.parseInt(actorlst[i]);
			actorsListMov.add(em.find(Actor.class, actorid[i]));
		}

		m.setActors(actorsListMov);

		em.persist(m);
		tran.commit();
		em.close();
	}

	public void findMovieByTitle() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		Query query = em.createQuery("select m from Movie m where m.title = :title");
		System.out.println("enter the title");
		query.setParameter("title", s.next());
		Movie movie = (Movie) query.getSingleResult();

		if (movie == null) {
			System.err.println("no movie found");
		} else {
			System.out.println(movie);
		}

		tran.commit();
		em.close();
	}

	public void findMovieByGenre() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		Query query = em.createQuery("select m from Movie m where m.genre = :genre");
		System.out.println("enter the genre");
		query.setParameter("genre", s.next());
		Movie movie = (Movie) query.getSingleResult();

		if (movie == null) {
			System.err.println("no movie found");
		} else {
			System.out.println(movie);
		}

		tran.commit();
		em.close();
	}

	public void findMoviesByDirector() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		System.out.println("enter director name");
		cq.where(cb.equal(root.get("director"), s.next()));
		Query query = em.createQuery(cq);
		List<Movie> movies = query.getResultList();

		if (movies.isEmpty()) {
			System.err.println("no movies found");
		} else {
			for (Movie movie : movies) {
				System.out.println(movie);
			}
		}

		tran.commit();
		em.close();
	}

	public void findMoviesByActorName() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
		Root<Actor> root = cq.from(Actor.class);
		System.out.println("enter actor name");
		cq.where(cb.equal(root.get("actorName"), s.next()));
		Query query = em.createQuery(cq);
		Actor actor = (Actor) query.getSingleResult();

		List<Movie> movies = actor.getMovies();

		if (movies.isEmpty()) {
			System.err.println("no movies found");
		} else {
			for (Movie movie : movies) {
				System.out.println(movie);
			}
		}

		tran.commit();
		em.close();
	}

	public void updateMoviesCollectionByVerdict() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		System.out.println("enter verdict");
		Query query = em.createQuery("select m from Movie m where m.verdict = :verdict");
		query.setParameter("verdict", s.next());
		List<Movie> movies = query.getResultList();
		System.out.println("enter new collection");
		int collection = s.nextInt();

		for (Movie movie : movies) {
			movie.setCollection(movie.getCollection() + collection);
			em.persist(movie);
		}
		System.out.println("collections updated");

		tran.commit();
		em.close();
	}

	public void updateMovieVerdictBetweenCollection() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> root = cq.from(Movie.class);
		System.out.println("enter collection range");
		cq.where(cb.between(root.get("collection"), s.nextInt(), s.nextInt()));
		Query query = em.createQuery(cq);
		List<Movie> movies = query.getResultList();

		System.out.println("enter new verdict");
		String verdict = s.next();

		if (movies.isEmpty()) {
			System.err.println("no movies found");
		} else {
			for (Movie movie : movies) {
				movie.setVerdict(verdict);
				em.persist(movie);
			}
		}

		System.out.println("verdict updated");
		tran.commit();
		em.close();
	}

	public void deleteMoviesByVerdict() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		Query query = em.createQuery("select m from Movie m where m.verdict = :verdict");
		System.out.println("enter verdict to delete movies");
		query.setParameter("verdict", s.next());
		List<Movie> movies = query.getResultList();
		for (Movie movie : movies) {
			em.remove(movie);
		}
		System.out.println("movies are deleted");

		tran.commit();
		em.close();
	}

	public void deleteMoviesByActorId() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
		Root<Actor> root = cq.from(Actor.class);
		System.out.println("enter actor id");
		cq.where(cb.equal(root.get("actorId"), s.nextInt()));
		Query query = em.createQuery(cq);
		Actor actor = (Actor) query.getSingleResult();
		List<Movie> moviesActor = actor.getMovies();
		List<Movie> movies = new ArrayList<>(actor.getMovies());
		moviesActor.clear();

		for (Movie movie : movies) {
			em.remove(movie);
		}

		System.out.println("movies are deleted");
		actor.setMovies(moviesActor);
		em.persist(actor);
		tran.commit();
		em.close();
	}
}
