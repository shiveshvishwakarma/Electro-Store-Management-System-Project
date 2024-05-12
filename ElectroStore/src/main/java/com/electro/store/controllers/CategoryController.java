package com.electro.store.controllers;

import com.electro.store.dtos.ApiResponceMessage;
import com.electro.store.dtos.CategoryDto;
import com.electro.store.dtos.PageableResponce;
import com.electro.store.dtos.ProductDto;
import com.electro.store.services.CategoryService;
import com.electro.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    //create
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        //call service to save to object
        CategoryDto categoryDto1 = categoryService.create(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);

    }

    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable String categoryId,
            @RequestBody CategoryDto categoryDto
    ){
        CategoryDto updatedCategory = categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);

    }


    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponceMessage> deleteCategory(
            @PathVariable String categoryId
    ){
        categoryService.delete(categoryId);
        ApiResponceMessage responceMessage = ApiResponceMessage.builder().message("Category is deleted successfully !!").status(HttpStatus.OK).success(true).build();
        return new ResponseEntity<>(responceMessage,HttpStatus.OK);


    }


    //get all
    @GetMapping
    public  ResponseEntity<PageableResponce<CategoryDto>> getAll(
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "title",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    ){
        PageableResponce<CategoryDto> pageableResponse = categoryService.getAll(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(pageableResponse,HttpStatus.OK);
    }


    //get single
    @GetMapping("/categoryId")
    public ResponseEntity<CategoryDto> getSingle(@PathVariable String categortId){

        CategoryDto categoryDto = categoryService.get(categortId);
        return ResponseEntity.ok(categoryDto);

    }

    //create product with category
    @PostMapping("/{categoryId}/products")
    public ResponseEntity<ProductDto> createProductWithCategory(
            @PathVariable("categoryId") String categoryId,
            @RequestBody ProductDto dto
    ){
        ProductDto productwithCategory = productService.createWithCategory(dto, categoryId);
        return new ResponseEntity<>(productwithCategory,HttpStatus.CREATED);

    }

    //update category of product
    @PutMapping("/{categoryid}/products/{productId}")
    public ResponseEntity<ProductDto> updateCategoryOfProduct(
            @PathVariable String categoryId,
            @PathVariable String productId
    ){
        ProductDto productDto = productService.updateCategory(productId, categoryId);
        return new ResponseEntity<>(productDto,HttpStatus.OK);

    }


    @PutMapping("/{categoryid}")
    public ResponseEntity<PageableResponce<ProductDto>> getProductOfCategory(
            @PathVariable String categoryId,
            @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "title",required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir

    ){
        PageableResponce<ProductDto> responce = productService.getAllOfCategory(categoryId, pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }



}
