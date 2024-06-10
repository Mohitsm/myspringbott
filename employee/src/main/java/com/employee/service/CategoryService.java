package com.employee.service;

import java.util.List;

import com.employee.dto.CategoryDto;





public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);
	void deleteCategory(Long categoryId);
	CategoryDto getCategoryById(Long categoryId);
	List<CategoryDto> getAllCategory();
	public Long countCategory();

}
