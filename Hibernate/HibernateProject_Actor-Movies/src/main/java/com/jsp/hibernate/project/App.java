package com.jsp.hibernate.project;

import java.util.Scanner;

import com.jsp.hibernate.actor_movies.dao.ActorDao;
import com.jsp.hibernate.actor_movies.dao.MovieDao;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ActorDao actorDao = new ActorDao();
		MovieDao movieDao = new MovieDao();

		while (true) {
			System.out.println("\n=== Actor Management System ===");
			System.out.println("1. Add Actor");
			System.out.println("2. Find Actor by ID");
			System.out.println("3. Find All Actors by Name");
			System.out.println("4. Find All Actors by Industry");
			System.out.println("5. Find All Actors Between Age Range");
			System.out.println("6. Find All Actors by Movie ID");
			System.out.println("7. Update All Actors' Salary by Movie ID");
			System.out.println("8. Delete All Actors with Salary Greater Than");
			System.out.println("9. Delete All Actors by Movie Genre");
			System.out.println("------------Movie Options----------------");
			System.out.println("10. Add Movie");
			System.out.println("11. findMovieByTitle");
			System.out.println("12. findMovieByGenre");
			System.out.println("13. findMoviesByDirector");
			System.out.println("14. findMoviesByActorName");
			System.out.println("15. updateMoviesCollectionByVerdict");
			System.out.println("16. updateMovieVerdictBetweenCollection");
			System.out.println("17. deleteMoviesByVerdict");
			System.out.println("18. deleteMoviesByActorId");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				actorDao.addActor();
				break;
			case 2:
				actorDao.findActorById();
				break;
			case 3:
				actorDao.findAllActorsByName();
				break;
			case 4:
				actorDao.findAllActorsByIndustry();
				break;
			case 5:
				actorDao.findAllActorsBetweenAge();
				break;
			case 6:
				actorDao.findAllActorsByMovieId();
				break;
			case 7:
				actorDao.updateAllActorsSalaryByMovieId();
				break;
			case 8:
				actorDao.deleteAllActorsWithSalaryGreaterThan();
				break;
			case 9:
				actorDao.deleteAllActorsByMovieGenre();
				break;
			case 10:
				movieDao.addMovie();
				break;
			case 11:
				movieDao.findMovieByTitle();
				break;
			case 12:
				movieDao.findMovieByGenre();
				break;
			case 13:
				movieDao.findMoviesByDirector();
				break;
			case 14:
				movieDao.findMoviesByActorName();
				break;
			case 15:
				movieDao.updateMoviesCollectionByVerdict();
				break;
			case 16:
				movieDao.updateMovieVerdictBetweenCollection();
				break;
			case 17:
				movieDao.deleteMoviesByVerdict();
				break;
			case 18:
				movieDao.deleteMoviesByActorId();
				break;
			case 0:
				System.out.println("Exiting... Thank you!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice! Please enter a valid option.");
			}
		}
	}
}
