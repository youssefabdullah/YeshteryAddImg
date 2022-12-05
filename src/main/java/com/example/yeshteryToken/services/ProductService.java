package com.example.yeshteryToken.services;

import com.example.yeshteryToken.entity.Products;
import com.example.yeshteryToken.model.ProductBeans;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public Products create(ProductBeans product, MultipartFile file);
    public List<Products> getAll();
    public List<Products> getAllAdmin();
    public Products getOneUser(int id);

    public Products update(Products product);

    public void delete(int id);
}
