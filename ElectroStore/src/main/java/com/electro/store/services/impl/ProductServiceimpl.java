package com.electro.store.services.impl;

import com.electro.store.dtos.PageableResponce;
import com.electro.store.dtos.ProductDto;
import com.electro.store.entites.Category;
import com.electro.store.entites.Product;
import com.electro.store.expections.ResourceNotFoundException;
import com.electro.store.helper.Helper;
import com.electro.store.repostories.CategoryRepository;
import com.electro.store.repostories.ProductRepository;
import com.electro.store.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductServiceimpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    //other Dependancy
    @Override
    public ProductDto create(ProductDto productDto) {
        Product product = mapper.map(productDto, Product.class);

        //product id
        String productId = UUID.randomUUID().toString();
        product.setProductId(productId);

        //added
        product.setAddedDate(new Date());
        Product saveProduct = productRepository.save(product);
        return mapper.map(saveProduct, ProductDto.class);
    }

    @Override
    public ProductDto update(ProductDto productDto, String productId) {

        //fetch th product of given id
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found of given id !!"));
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setQuantity(productDto.getQuantity());
        product.setLive(productDto.isLive());
        product.setStock(productDto.isStock());
        product.setProductImageName(productDto.getProductImageName());

        //save the entity
        Product updatedProduct = productRepository.save(product);
        return mapper.map(updatedProduct, ProductDto.class);
    }

    @Override
    public void delete(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found of given id !!"));
        productRepository.delete(product);


    }

    @Override
    public ProductDto get(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found of given id !!"));
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public PageableResponce<ProductDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        Sort sort=(sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) : (Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber, pageSize, sort);
        Page<Product> page = productRepository.findAll(pageable);
        return Helper.getPagableResponce(page, ProductDto.class);
    }

    @Override
    public  PageableResponce<ProductDto> getAllLive(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort=(sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) : (Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber, pageSize, sort);
        Page<Product> page = productRepository.findByLiveTrue(pageable);
        return Helper.getPagableResponce(page, ProductDto.class);
    }

    @Override
    public PageableResponce<ProductDto>searchByTitle(String subTitle, int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort=(sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) : (Sort.by(sortBy).ascending());
        Pageable pageable= PageRequest.of(pageNumber, pageSize, sort);
        Page<Product> page = productRepository.findByTitleContaining(subTitle, pageable);
        return Helper.getPagableResponce(page, ProductDto.class);
    }

    @Override
    public ProductDto createWithCategory(ProductDto productDto, String categoryId) {

        //fetch the category from db:
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found !!"));
        Product product = mapper.map(productDto, Product.class);
        //product id
        String productId = UUID.randomUUID().toString();
        product.setProductId(productId);
        //added
        product.setAddedDate(new Date());
        product.setCategory(category);
        Product saveProduct = productRepository.save(product);
        return mapper.map(saveProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateCategory(String productId, String categoryId) {

        //product fetch
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product of given id not found !!"));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category of given id not found!!"));
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return mapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public PageableResponce<ProductDto> getAllOfCategory(String categoryId,int pageNumber, int pageSize, String sortBy,String sortDir) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category of given id not found!!"));

        Sort sort=(sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) : (Sort.by(sortBy).ascending());

        Pageable pageable= PageRequest.of(pageNumber, pageSize,sort);
        Page<Product> page = productRepository.findByCategory(category, pageable);
        return Helper.getPagableResponce(page, ProductDto.class);
    }

}