package com.electro.store.services.impl;

import com.electro.store.dtos.CategoryDto;
import com.electro.store.dtos.PageableResponce;
import com.electro.store.entites.Category;
import com.electro.store.expections.ResourceNotFoundException;
import com.electro.store.helper.Helper;
import com.electro.store.repostories.CategoryRepository;
import com.electro.store.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        //creating categoryId:randomally

        String categoryId = UUID.randomUUID().toString();
        categoryDto.setCategoryId(categoryId);

        Category category = mapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return mapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {

        //get category of given id
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found Exception !!"));

        //update category details
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        category.setCoverImage(categoryDto.getCoverImage());
        Category updatedCategory = categoryRepository.save(category);

        return mapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void delete(String categoryId) {
        //get category of given id
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found Exception !!"));
        categoryRepository.delete(category);

    }

    @Override
    public PageableResponce<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {

        Sort sort=(sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) : (Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Page<Category> page = categoryRepository.findAll(pageable);
        PageableResponce<CategoryDto> pagableResponce = Helper.getPagableResponce(page, CategoryDto.class);
        return pagableResponce;
    }

    @Override
    public CategoryDto get(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found Exception !!"));
        return mapper.map(category,CategoryDto.class);
    }
}
