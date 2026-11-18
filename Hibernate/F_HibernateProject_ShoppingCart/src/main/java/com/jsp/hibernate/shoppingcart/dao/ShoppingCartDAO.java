package com.jsp.hibernate.shoppingcart.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.shoppingcart.entity.Cart;
import com.jsp.hibernate.shoppingcart.entity.Product;
import com.jsp.hibernate.shoppingcart.entity.User;

public class ShoppingCartDAO {
	Scanner sc = new Scanner(System.in);

	Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Cart.class)
			.addAnnotatedClass(Product.class);
	SessionFactory sf = cfg.buildSessionFactory();

	public void addProduct() {
		Product product = new Product();
		System.out.println("ADD PRODUCT VALUES");
		System.out.println();
		System.out.println("enter the product id");
		product.setProductID(sc.nextInt());
		System.out.println("enter the product name");
		product.setProductName(sc.next());
		System.out.println("enter the product brand");
		product.setBrand(sc.next());
		System.out.println("enter the product price");
		product.setPrice(sc.nextInt());

		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		session.save(product);

		tran.commit();
		session.close();
	}

	public void addUserWithCart() {
		User user = new User();
		Cart cart = new Cart();
		System.out.println("Enter the cart id");
		cart.setCartId(sc.nextInt());
		System.out.println("---------------");
		System.out.println("enter the user id");
		user.setUserId(sc.nextInt());
		System.out.println("enter the user name");
		user.setUserName(sc.next());
		System.out.println("enter the mail");
		user.seteMail(sc.next());
		System.out.println("enter the mobile no");
		user.setMobileNo(sc.nextLong());
		System.out.println("enter the location");
		user.setLocation(sc.next());

		user.setCart(cart);

		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		session.save(user);
		session.save(cart);

		tran.commit();
		session.close();

	}

	public void addProductToUserCart() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("enter the product Id you want to search");
		Product product = session.get(Product.class, sc.nextInt());

		if (product != null) {
			System.out.println("enter the user id you want to search");
			User user = session.get(User.class, sc.nextInt());

			if (user != null) {
				Cart cart = user.getCart();
				List<Product> pList = cart.getProducts();
				pList.add(product);

				session.update(cart);

				tran.commit();
				session.close();
				System.out.println("product added to the cart successfully");

			} else {
				System.out.println("user not found by id");
			}

		} else {
			System.out.println("product not found by id");
		}

	}

	public void removeProductFromUserCart() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("enter the user id");
		User user = session.get(User.class, sc.nextInt());

		if (user != null) {
			Cart cart = user.getCart();
			List<Product> pList = cart.getProducts();
			for (Product product : pList) {
				System.out.println(product);
			}
			System.out.println("enter id of the product to be removed");
			Product product = session.get(Product.class, sc.nextInt());
			pList.remove(product);

			session.update(cart);

			tran.commit();
			session.close();
			System.out.println("product remove from cart");

		} else {
			System.out.println("user not found by id");
		}

	}

	public void findAllProductsInCart() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("enter the user id");
		User user = session.get(User.class, sc.nextInt());
		if (user != null) {
			Cart cart = user.getCart();
			List<Product> pList = cart.getProducts();
			System.out.println("all products detalis");
			for (Product product : pList) {
				System.out.println(product);
				tran.commit();
				session.close();

			}
		} else {
			System.out.println("user not pound by id");
		}

	}

}
