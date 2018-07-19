package com.carthurnau.productscategories1.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.carthurnau.productscategories1.models.Product;
import com.carthurnau.productscategories1.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository pRepo;
	public ProductService(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}
	
	public ArrayList<Product> findAll() {
		return (ArrayList<Product>) pRepo.findAll();
	}
	
	public void addProduct(Product product) {
		pRepo.save(product);
	}

	public Product findById(Long id) {
		Product product = pRepo.findById(id);
		return product;
	}

	public void save(Product product) {
		pRepo.save(product);
	}
}
