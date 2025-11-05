package com.ecommerce.sb_ecomm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.sb_ecomm.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
