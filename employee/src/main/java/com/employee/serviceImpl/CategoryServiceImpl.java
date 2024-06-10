package com.employee.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Category;
import com.employee.exception.ResourceNotFoundException;
import com.employee.dto.CategoryDto;
import com.employee.repositiry.*;
import com.employee.service.*;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category=this.modelMapper.map(categoryDto, Category.class);
		Category createCategory=this.categoryRepo.save(category);
		return this.modelMapper.map(createCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		category.setCategoryName(categoryDto.getCategoryName());
		Category updateCategory=this.categoryRepo.save(category);
		return this.modelMapper.map(updateCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));

		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategoryById(Long categoryId) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));

		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto> getAllCategory=categories.stream().map((ct)->this.modelMapper.map(ct, CategoryDto.class)).collect(Collectors.toList());
		return getAllCategory;
	}

	@Override
	public Long countCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.count();
	}

}
