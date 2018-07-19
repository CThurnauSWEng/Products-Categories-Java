package com.carthurnau.productscategories1.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carthurnau.productscategories1.models.Category;
import com.carthurnau.productscategories1.models.Product;
import com.carthurnau.productscategories1.services.CategoryService;
import com.carthurnau.productscategories1.services.ProductService;

@Controller
@RequestMapping("/ProductsCategories")
public class ProdCatController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProdCatController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	
	@RequestMapping("")
	public String index(@ModelAttribute("product") Product product, Model model) {
		ArrayList<Product> products = (ArrayList<Product>) productService.findAll();
		model.addAttribute("products", products);
		return "index.jsp";
	}
	
	@PostMapping("createProduct")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			productService.addProduct(product);
			return "redirect:/ProductsCategories";
		}
	}
	
	@RequestMapping("newCategory")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		ArrayList<Category> categories = (ArrayList<Category>) categoryService.findAll();
		model.addAttribute("categories", categories);
		return "newCategory.jsp";
	}
	
	@PostMapping("createCategory")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			categoryService.addCategory(category);
			return "redirect:/ProductsCategories/newCategory";
		}
	}
	
	@RequestMapping("newLinkToProduct/{id}")
	public String addProdtoCat(@PathVariable("id") Long id, @ModelAttribute("category") Category category, Model model) {
		
		Category thisCategory = categoryService.findById(id);
		
		List<Product> catsProductList = thisCategory.getProducts();
		List<Product> allproductsList = productService.findAll();
		
		// remove the products that have already been linked to this category from the allproductsList
		for (Product p : catsProductList) {
			if (allproductsList.contains(p)) {
				allproductsList.remove(p);
			}
		}		
		model.addAttribute("thisCategory", thisCategory);
		model.addAttribute("thisCatsProducts", catsProductList);
		model.addAttribute("allProducts", allproductsList);
		return "newLinkToProduct.jsp";
	}
	
	@RequestMapping("newLinkToCategory/{id}")
	public String addCatToProd(@PathVariable("id") Long id, @ModelAttribute("product") Product product, Model model) {
		Product thisProduct = productService.findById(id);
		
		List<Category> thisProdsCats = thisProduct.getCategories();
		List<Category> allcategoriesList = categoryService.findAll();
		
		// remove the categories that have already been linked to this product from the allcategoriesList
		for (Category c : thisProdsCats) {
			if (allcategoriesList.contains(c)) {
				System.out.println("c.name: " + c.getName());
				allcategoriesList.remove(c);
			}
		}
		model.addAttribute("thisProduct", thisProduct);
		model.addAttribute("allCategories", allcategoriesList);
		model.addAttribute("thisProdsCats", thisProdsCats);
		return "newLinkToCategory.jsp";
	}
	
	@PostMapping("newLinkToProduct")
	public String createProdLink(@RequestParam(value="this_product") Product chosenProduct, @RequestParam(value="thisCategory") Category thisCategory) {
		
		thisCategory.getProducts().add(chosenProduct);
		categoryService.save(thisCategory);
		
		// it would be nice to return to link another product, but can't get that working yet
		
		return "redirect:/ProductsCategories/newCategory";
	}
	
	@PostMapping("newLinkToCategory")
	public String createCatLink(@RequestParam(value="this_category") Category chosenCategory, @RequestParam(value="thisProduct") Product thisProduct) {
		
		thisProduct.getCategories().add(chosenCategory);
		productService.save(thisProduct);
		
		return "redirect:/ProductsCategories";
	}
	
}
