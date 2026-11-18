package com.jsp.spring.playerdb;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.spring.playerdb.controller.PlayerController;


public class App 
{
	public static void main( String[] args )
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		PlayerController pc = ac.getBean(PlayerController.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Operation No: ");
		System.out.println("1. Add Player ");
		System.out.println("2. Find Player By Id ");
		System.out.println("3. Find Player By Name ");
		System.out.println("4. Find All Players By Nationality ");
		System.out.println("5. Find All Players Between Age ");
		System.out.println("6. Find All Players By Salary Greater Than ");
		System.out.println("7. Update Player Salary By IPL Team ");
		System.out.println("8. Update Player IPL Team By Name ");
		System.out.println("9. Delete All Players By IPL Team ");
		System.out.println("10. Delete Players Between Salary ");

		int choice = sc.nextInt();
		sc.nextLine();  

		switch (choice) {
		case 1:
			pc.addPlayer();
			break;
		case 2:
			pc.findPlayerById();
			break;
		case 3:
			pc.findPlayerByName();
			break;
		case 4:
			pc.findAllPlayersByNationality();
			break;
		case 5:
			pc.findAllPlayersBetweenAge();
			break;
		case 6:
			pc.findAllPlayersSalaryGreaterThan();
			break;
		case 7:
			pc.updatePlayerSalaryByIplTeam();
			break;
		case 8:
			pc.updatePlayerIplTeamByName();
			break;
		case 9:
			pc.deleteAllPlayersByIplTeam();
			break;
		case 10:
			pc.deletePlayersBetweenSalary();
			break;
		default:
			System.out.println("Invalid Choice! Please enter 1 or 2.");
		}
	}
}
