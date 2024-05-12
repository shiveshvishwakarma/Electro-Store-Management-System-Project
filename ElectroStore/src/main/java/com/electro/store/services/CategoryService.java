package com.electro.store.services;

import com.electro.store.dtos.CategoryDto;
import com.electro.store.dtos.PageableResponce;

public interface CategoryService {


    //create
    CategoryDto create(CategoryDto categoryDto);


    //update
    CategoryDto update(CategoryDto categoryDto, String categoryId);


    //delete
    void delete(String categoryId);


    //get all
    PageableResponce<CategoryDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);


    //get single category detail
    CategoryDto get(String categoryId);


    //search
}
