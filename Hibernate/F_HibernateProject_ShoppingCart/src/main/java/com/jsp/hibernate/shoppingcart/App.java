package com.jsp.hibernate.shoppingcart;

import java.util.Scanner;

import com.jsp.hibernate.shoppingcart.dao.ShoppingCartDAO;

public class App 
{
    public static void main( String[] args )
    {
    	ShoppingCartDAO s1=new ShoppingCartDAO();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the option:");
    	System.out.println("1: add product");
    	System.out.println("2: addUserWithCart");
    	System.out.println("3: addProductToUserCart");
    	System.out.println("4: removeProductFromUserCart");
    	System.out.println("5: findAllProductsInCart");
    	System.out.println("6: exit");
    	int option=sc.nextInt();
    	
    	boolean exit=true;
    	
    	while(exit) {
    		switch (option) {
    		case 1:
    			s1.addProduct();
    			break;
    		case 2:
    			s1.addUserWithCart();
    			break;
    		case 3:
    			s1.addProductToUserCart();
    			break;
    		case 4:
    			s1.removeProductFromUserCart();
    			break;
    		case 5:
    			s1.findAllProductsInCart();
    			break;
    		case 6:
    			exit=false;
    			break;
    		default:
    			break;
    		}
    	}
    }
    
}
