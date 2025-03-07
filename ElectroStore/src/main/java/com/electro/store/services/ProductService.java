package com.electro.store.services;

import com.electro.store.dtos.PageableResponce;
import com.electro.store.dtos.ProductDto;

import javax.management.StandardEmitterMBean;
import java.security.SecureRandom;
import java.util.List;

public interface ProductService {

    //create
    ProductDto create(ProductDto productDto);

    //update
    ProductDto update(ProductDto productDto, String productId);

    //delete
    void delete(String productId);

    //get single
    ProductDto get(String productId);

    //get all
    PageableResponce<ProductDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);

    //get all : live
    PageableResponce<ProductDto> getAllLive(int pageNumber, int pageSize, String sortBy, String sortDir);

    //search product
    PageableResponce<ProductDto>searchByTitle(String subTitle, int pageNumber, int pageSize, String sortBy, String sortDir);


    //create product with category
    ProductDto createWithCategory(ProductDto productDto, String categoryId);

    //update category of product
    ProductDto updateCategory(String productId, String categoryId);

    PageableResponce<ProductDto> getAllOfCategory(String categoryId, int pageNumber, int pageSize, String sortBy,String sortDir );

}
