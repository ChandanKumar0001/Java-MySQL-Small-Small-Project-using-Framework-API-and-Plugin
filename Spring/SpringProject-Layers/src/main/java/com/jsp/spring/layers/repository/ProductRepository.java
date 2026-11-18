package com.jsp.spring.layers.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jsp.spring.layers.entity.Product;

@Repository
public class ProductRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");

	public void addProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(product);
		et.commit();
		em.close();
	}
	
	public Product findProductById(int productId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Product product = em.find(Product.class, productId);

		et.commit();
		em.close();
		
		return product;
	}
	
	public void updateById(Product product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.merge(product);
		
		et.commit();
		em.close();
		
	}
	
	public void deleteById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Product product = em.find(Product.class, id);
		em.remove(product);
		
		et.commit();
		em.close();
	
	}
}
