package com.jsp.spring.layers;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.spring.layers.controller.ProductController;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductController pc = ac.getBean(ProductController.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Operation No: ");
        System.out.println("1. Add Products ");
        System.out.println("2. Find Product By Id ");
        System.out.println("3. Update Product By Id ");
        System.out.println("4. Delete Product By Id ");
        int choice = sc.nextInt();
        sc.nextLine();  // Consume newline
        
        switch (choice) {
        case 1:
            pc.addProduct();
            break;
        case 2:
            pc.findProduct();
            break;
        case 3:
        	pc.updateById();
        	break;
        case 4:
        	pc.deleteById();
        	break;
        default:
            System.out.println("Invalid Choice! Please enter 1 or 2.");
    }
    }
}
