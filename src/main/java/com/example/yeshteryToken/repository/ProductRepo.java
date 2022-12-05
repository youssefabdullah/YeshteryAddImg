package com.example.yeshteryToken.repository;

import com.example.yeshteryToken.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {
}
