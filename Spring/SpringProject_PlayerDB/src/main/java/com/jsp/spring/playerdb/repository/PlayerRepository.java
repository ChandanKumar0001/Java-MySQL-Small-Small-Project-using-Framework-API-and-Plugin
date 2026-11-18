package com.jsp.spring.playerdb.repository;

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

import org.springframework.stereotype.Repository;

import com.jsp.spring.playerdb.entity.Player;

@Repository
public class PlayerRepository {

	Scanner sc = new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");

	public void addPlayer(Player player) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(player);
		et.commit();
		em.close();
	}

	public Player findPlayerById(int playerId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Player player = em.find(Player.class, playerId);

		et.commit();
		em.close();

		return player;
	}

	public List<Player> findPlayerByName(String playerName) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = emf.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);

		cq.where(cb.like(root.get("playerName"), "%" + playerName + "%"));

		Query query = em.createQuery(cq);
		List<Player> players = query.getResultList();
		et.commit();

		return players;
	}

	public List<Player> findPlayerByNationality(String nationality) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = emf.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);

		cq.where(cb.equal(root.get("nationality"), nationality));

		Query query = em.createQuery(cq);
		List<Player> players = query.getResultList();

		et.commit();
		return players;
	}

	public List<Player> findAllPlayersBetweenAge(int startAge, int endAge) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = emf.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);

		cq.where(cb.between(root.get("Age"), startAge, endAge));

		Query query = em.createQuery(cq);
		List<Player> players = query.getResultList();
		et.commit();

		return players;
	}

	public List<Player> findPlayersBySalaryGreaterThan(int salary) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = emf.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);

		cq.where(cb.greaterThan(root.get("salary"), salary));

		Query query = em.createQuery(cq);
		List<Player> players = query.getResultList();
		et.commit();

		return players;
	}

	public List<Player> updatePlayerSalaryByIplTeam(String iplTeam) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = emf.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);

		cq.where(cb.equal(root.get("iplTeam"), iplTeam));

		Query query = em.createQuery(cq);
		List<Player> players = query.getResultList();

		for (Player player : players) {
			player.setSalary(player.getSalary() + 100001);
			em.merge(player);
		}

		et.commit();

		return players;
	}

	public Player updatePlayerIplTeamByName(String player) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = emf.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);

		cq.where(cb.equal(root.get("playerName"), player));

		Query query = em.createQuery(cq);
		List<Player> players = query.getResultList();
		Player p = players.get(0);
		System.out.println("Enter the New IPL Team: ");
		p.setIplTeam(sc.next());

		em.merge(p);
		et.commit();
		return p;
	}

	public int deleteAllPlayersByIplTeam(String iplTeam) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = emf.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);

		cq.where(cb.equal(root.get("iplTeam"), iplTeam));

		Query query = em.createQuery(cq);
		List<Player> players = query.getResultList();

		int count = 0;
		for (Player player : players) {
			em.remove(player);
			count++;
		}
		et.commit();
		return count;
	}

	public int deletePlayersBetweenSalary(int startSalary, int endSalary) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		CriteriaBuilder cb = emf.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		Root<Player> root = cq.from(Player.class);

		cq.where(cb.between(root.get("salary"), startSalary, endSalary));

		Query query = em.createQuery(cq);
		List<Player> players = query.getResultList();

		int count = 0;
		for (Player player : players) {
			em.remove(player);
			count++;
		}
		et.commit();
		return count;
	}
}
