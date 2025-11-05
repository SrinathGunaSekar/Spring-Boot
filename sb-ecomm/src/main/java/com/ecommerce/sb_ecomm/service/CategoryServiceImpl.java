package com.ecommerce.sb_ecomm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.sb_ecomm.model.Category;
import com.ecommerce.sb_ecomm.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {


	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public void createCategory(Category category) {
		
		categoryRepository.save(category);
		
	}

	@Override
	public String deleteCategory(Long categoryId) {
		Optional<Category> categories = categoryRepository.findById(categoryId);
		
		Category category = categories
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));
		
		categoryRepository.delete(category);
		return "category Id :" + categoryId + " is deleted";
	}

	@Override
	public Category updateCategory(Category category, Long categoryId) {
		Optional<Category> categories = categoryRepository.findById(categoryId);
		
		Category savedCategory = categories
								.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));
		category.setCategoryId(categoryId);
		savedCategory = categoryRepository.save(category);
		return savedCategory;
	}
	
	
}
