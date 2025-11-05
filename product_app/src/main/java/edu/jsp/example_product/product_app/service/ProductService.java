package edu.jsp.example_product.product_app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.jsp.example_product.product_app.entity.Product;
import edu.jsp.example_product.product_app.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product p) {
		return repository.save(p);
	}
	
	public Product getById(int id) {
		Optional<Product> o = repository.findById(id);
		
		return o.isPresent()?o.get():null;
	}
	
	public List<Product> getAll(){
		return repository.findAll();
	}
	
	public String deleteById(int id) {
		Optional<Product> o = repository.findById(id);
		if(o.isPresent()) {
			Product p = o.get();
			repository.delete(p);
			return "Product Deleted";
		}
		return "Product Not found";
	}
	
	public String updateProduct(int id,Product newProduct) {
		Optional<Product> o = repository.findById(id);
		if(o.isPresent()) {
			Product p = o.get();
			p.setName(newProduct.getName());
			p.setQty(newProduct.getQty());
			p.setManufacture_date(newProduct.getManufacture_date());
			p.setModel(newProduct.getModel());
			p.setType(newProduct.getType());
			p.setPrice(newProduct.getPrice());
			p.setRating(newProduct.getRating());
			
			repository.save(p);
			return "Product Updated";
		}
		
		return "Product Not found";
	}
	
	public List<Product> searchProductByType(String type) {
		return repository.findByType(type);
	}
	
	public List<Product> getAllProductByPrice(double st, double end){
		
		return repository.findByPriceBetween(st, end);
	}
	
	public List<Product> getAllProductByRating(int rating){
		return repository.findByRating(rating);
	}
	
	public List<Product> sortByPrice(){
	
		return repository.orderByPrice();
	}
}
