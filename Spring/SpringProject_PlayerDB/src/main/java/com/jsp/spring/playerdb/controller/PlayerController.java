package com.jsp.spring.playerdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jsp.spring.playerdb.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	public void addPlayer() {
		playerService.addPlayer();
	}
	
	public void findPlayerById() {
		playerService.findPlayerById();
	}
	
	public void findPlayerByName() {
		playerService.findPlayerByName();
	}
	
	public void findAllPlayersByNationality() {
		playerService.findAllPlayersByNationality();
	}
	
	public void findAllPlayersBetweenAge() {
		playerService.findAllPlayersBetweenAge();
	}
	
	public void findAllPlayersSalaryGreaterThan() {
		playerService.findAllPlayersBySalaryGreaterThan();
	}
	
	public void updatePlayerSalaryByIplTeam() {
		playerService.updatePlayersSalaryByIplTeam();
	}
	
	public void updatePlayerIplTeamByName() {
		playerService.updatePlayerIplTeamByName();
	}
	
	public void deleteAllPlayersByIplTeam() {
		playerService.deleteAllPlayersByIplTeam();
	}
	
	public void deletePlayersBetweenSalary() {
		playerService.deletePlayersBetweenSalary();
	}
}
