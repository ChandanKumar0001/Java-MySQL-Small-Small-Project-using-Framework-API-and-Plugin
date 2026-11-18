package com.jsp.spring.layers.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spring.layers.entity.Product;
import com.jsp.spring.layers.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	Scanner scan = new Scanner(System.in);
	
	public void addProduct() {
		Product product = new Product();
		
		System.out.println("Enter ProductId: ");
		product.setProductId(scan.nextInt());
		System.out.println("Enter Name: ");
		product.setProductName(scan.next());
		System.out.println("Enter Brand: ");
		product.setBrand(scan.next());
		System.out.println("Enter Price: ");
		product.setPrice(scan.nextInt());
		
		productRepository.addProduct(product);
		
		System.out.println("Product Added Successfully!!");
	}
	
	public void findProductById() {
		System.out.println("Enter Product Id: ");
		Product product = productRepository.findProductById(scan.nextInt());
		
		if(product !=null) {
			System.out.println("Product Id: "+product.getProductId());
			System.out.println("Product Name: "+product.getProductName());
			System.out.println("Product Brand: "+product.getBrand());
			System.out.println("Product Price: "+product.getPrice());
		}else {
			System.err.println("Product Not Found By Id!!");
		}
	}
	
	public void updateById() {
		System.out.println("Enter Product Id: ");
		Product product = productRepository.findProductById(scan.nextInt());
		
		if(product != null) {
			System.out.println("Enter Product Name, Brand , Price ");
			product.setProductName(scan.next());
			product.setBrand(scan.next());
			product.setPrice(scan.nextInt());
			productRepository.updateById(product);
			System.out.println("Updated Successfully");
		}else {
			System.err.println("Product Id is Invalid!!");
		}
	}
	
	public void deleteById() {
		System.out.println("Enter Product Id: ");
		Product product = productRepository.findProductById(scan.nextInt());
		
		if(product != null) {
			productRepository.deleteById(product.getProductId());
			System.out.println("Deleted Successfully!!");
		}else {
			System.err.println("Product Id is Invalid!!");
		}
	}
}
