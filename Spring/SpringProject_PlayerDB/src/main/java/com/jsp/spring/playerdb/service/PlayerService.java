package com.jsp.spring.playerdb.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spring.playerdb.entity.Player;
import com.jsp.spring.playerdb.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	Scanner scan = new Scanner(System.in);
	
	public void addPlayer() {
		Player player = new Player();
		
		System.out.println("Enter PlayerId: ");
		player.setPlayerId(scan.nextInt());
		System.out.println("Enter Name: ");
		player.setPlayerName(scan.next());
		System.out.println("Enter Age: ");
		player.setAge(scan.nextInt());
		System.out.println("Enter Salary: ");
		player.setSalary(scan.nextInt());
		System.out.println("Enter IPL Team: ");
		player.setIplTeam(scan.next());
		System.out.println("Enter Nationality: ");
		player.setNationality(scan.next());
		
		playerRepository.addPlayer(player);
		
		System.out.println("Player Added SuccessFully!!");
	}
	
	public void findPlayerById() {
		System.out.println("Enter Player Id: ");
		
		Player player = playerRepository.findPlayerById(scan.nextInt());
		
		if(player != null) {
			System.out.println("Player Id: "+player.getPlayerId());
			System.out.println("Player Name: "+player.getPlayerName());
			System.out.println("Player Age: "+player.getAge());
			System.out.println("Player Salary: "+player.getSalary());
			System.out.println("Player IPl Team: "+player.getIplTeam());
			System.out.println("Player Nationality: "+player.getNationality());
		} else {
			System.err.println("Player Id is Invalid please give valid ID!!");
		}
		
	}
	
	public void findPlayerByName() {
		System.out.println("Enter Player Name: ");
		String name = scan.next();
		
		List<Player> player = playerRepository.findPlayerByName(name);
		
		if(player != null) {
			System.out.println(player);
		}else {
			System.err.println("No Player Found !!");
		}
		
	}
	
	public void findAllPlayersByNationality() {
		System.out.println("Enter Player Nationality: ");
		String nationality = scan.next();
		
		List<Player> players = playerRepository.findPlayerByNationality(nationality);
		
		if(players != null) {
			for(Player player : players) {
				System.out.println(player);
			}
		} else {
			System.err.println("No Players Found !!");
		}
	}
	
	public void findAllPlayersBetweenAge() {
		
		System.out.println("Enter the Player Starting Age: ");
		int startAge = scan.nextInt();
		System.out.println("Enter the Player Ending Age: ");
		int endAge = scan.nextInt();
		
		List<Player> players = playerRepository.findAllPlayersBetweenAge(startAge, endAge);
		
		if(players != null) {
			for(Player player : players) {
				System.out.println(player);
			}
		} else {
			System.err.println("No Players Found !!");
		}
	}
	
	public void findAllPlayersBySalaryGreaterThan() {
		
		System.out.println("Enter the Player Salary: ");
		int salary = scan.nextInt();
		
		List<Player> players = playerRepository.findPlayersBySalaryGreaterThan(salary);
		
		if(players != null) {
			for(Player player : players) {
				System.out.println(player);
			}
		} else {
			System.err.println("No Players Found !!");
		}
	}
	
	public void updatePlayersSalaryByIplTeam() {
		
		System.out.println("Enter the IPL Team: ");
		String iplTeam = scan.next();
		
		List<Player> players = playerRepository.updatePlayerSalaryByIplTeam(iplTeam);
		
		System.out.println("Players with the Team: "+iplTeam+ "and their updated salary are:-");
		
		if(players != null) {
			for(Player player : players) {
				System.out.println(player);
			}
		} else {
			System.err.println("No Players Found !!");
		}
	}
	
	public void updatePlayerIplTeamByName() {
		
		System.out.println("Enter the Player Name: ");
		String player = scan.next();
		
		Player p = playerRepository.updatePlayerIplTeamByName(player);
		System.out.println("Player "+player+"has been changed to Team: "+p.getIplTeam());
		
	}
	
	public void deleteAllPlayersByIplTeam() {
		
		System.out.println("Enter the Team Name: ");
		String iplTeam = scan.next();
		
		int rowsDeleted = playerRepository.deleteAllPlayersByIplTeam(iplTeam);
		
		System.out.println(rowsDeleted+" Players has been Deleted !!");
	}
	
	public void deletePlayersBetweenSalary() {
		
		System.out.println("Enter the Player Starting Salary: ");
		int startSalary = scan.nextInt();
		System.out.println("Enter the Player Ending Salary: ");
		int endSalary = scan.nextInt();
		
		int rowsDeleted = playerRepository.deletePlayersBetweenSalary(startSalary, endSalary);
		
		System.out.println(rowsDeleted+" Players has been Deleted !!");
	}
}
