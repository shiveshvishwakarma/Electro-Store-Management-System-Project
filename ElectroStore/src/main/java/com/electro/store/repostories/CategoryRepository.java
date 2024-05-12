package com.electro.store.repostories;

import com.electro.store.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
