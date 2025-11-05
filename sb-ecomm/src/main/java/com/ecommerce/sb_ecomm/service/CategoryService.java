package com.ecommerce.sb_ecomm.service;

import java.util.List;

import com.ecommerce.sb_ecomm.model.Category;

public interface CategoryService {

	List<Category> getCategories();
	void createCategory(Category category);
	String deleteCategory(Long categoryId);
	Category updateCategory(Category category, Long categoryId);
}
