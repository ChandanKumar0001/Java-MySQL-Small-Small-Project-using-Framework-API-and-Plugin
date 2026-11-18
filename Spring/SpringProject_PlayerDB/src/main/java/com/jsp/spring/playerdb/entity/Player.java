package com.jsp.spring.playerdb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	private int playerId;
	private String playerName;
	private int Age;
	private int salary;
	private String iplTeam;
	private String nationality;
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getIplTeam() {
		return iplTeam;
	}
	public void setIplTeam(String iplTeam) {
		this.iplTeam = iplTeam;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", Age=" + Age + ", salary=" + salary
				+ ", iplTeam=" + iplTeam + ", nationality=" + nationality + "]";
	}
	
	
}
