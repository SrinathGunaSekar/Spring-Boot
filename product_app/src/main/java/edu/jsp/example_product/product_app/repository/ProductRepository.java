package edu.jsp.example_product.product_app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.jsp.example_product.product_app.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

	//save(product p)
	//findById(int id)
	//findByAll()
	//deleteById(int id)
	//delete(product p)
	
	List<Product> findByType(String type);
	
	List<Product> findByPriceBetween(double st,double end);
	
	List<Product> findByRating(int rating);
	
	@Query(value = "select p from Product p ORDER BY p.price  ASC")
	List<Product> orderByPrice();
}
