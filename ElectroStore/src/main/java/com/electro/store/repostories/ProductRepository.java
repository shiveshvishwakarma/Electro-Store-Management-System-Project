package com.electro.store.repostories;

import com.electro.store.entites.Category;
import com.electro.store.entites.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>
{
    //search

    Page<Product> findByTitleContaining(String subTitle, Pageable pageable);
    Page<Product> findByLiveTrue(Pageable pageable);
    Page<Product> findByCategory(Category category, Pageable pageable);

    //other methods
    //coustom finder methods
    //query methods
}
