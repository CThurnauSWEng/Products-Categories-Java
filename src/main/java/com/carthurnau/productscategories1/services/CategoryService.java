package com.carthurnau.productscategories1.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.carthurnau.productscategories1.models.Category;
import com.carthurnau.productscategories1.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository cRepo;
	public CategoryService(CategoryRepository cRepo) {
		this.cRepo = cRepo;
	}
	
	public ArrayList<Category> findAll() {
		return (ArrayList<Category>) cRepo.findAll();
	}
	
	public void addCategory(Category category) {
		cRepo.save(category);
	}

	public Category findById(Long id) {
		Category category = cRepo.findById(id);
		return category;
	}

	public void linkProduct(Category category) {
		cRepo.save(category);		
	}

	public void save(Category category) {
		cRepo.save(category);
	}
}
