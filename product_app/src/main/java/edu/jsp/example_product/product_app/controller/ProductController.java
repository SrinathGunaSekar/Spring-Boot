package edu.jsp.example_product.product_app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.example_product.product_app.entity.Product;
import edu.jsp.example_product.product_app.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product p) {
		return service.saveProduct(p);
	}
	
	@GetMapping("/getProductById")
	public Product getById(@RequestParam int id) {
		return service.getById(id);
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAll() {
		return service.getAll();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestParam int id,@RequestBody Product newProduct) {
		return service.updateProduct(id, newProduct);
	}
	
	@GetMapping("/searchProductByType/{type}")
	public List<Product> searchProductByType(@PathVariable String type) {
		return service.searchProductByType(type);
	}
	
	@GetMapping("/getByPrice")
	public List<Product> getAllProductByPrice(@RequestParam double st,@RequestParam double end){
		return service.getAllProductByPrice(st, end);
	}
	
	@GetMapping("/getByRating")
	public List<Product> getAllProductByRating(@RequestParam int rating){
		return service.getAllProductByRating(rating);
	}
	
	@GetMapping("/sortByPrice")
	public List<Product> sortByPrice(){
		return service.sortByPrice();
	}
}
