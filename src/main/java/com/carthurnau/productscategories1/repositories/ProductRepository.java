package com.carthurnau.productscategories1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carthurnau.productscategories1.models.Product;



@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();

	Product findById(Long id);

}
