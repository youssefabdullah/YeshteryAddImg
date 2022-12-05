package com.example.yeshteryToken.controller;

import com.example.yeshteryToken.entity.Products;
import com.example.yeshteryToken.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @RequestMapping("/landingpage")
    public List<Products> getAll() {
        return productService.getAll();
    }

    @GetMapping
    @RequestMapping("/admin")
    public List<Products> getAllAdmin() {
        return productService.getAllAdmin();
    }

    @GetMapping
    @RequestMapping("/admin/{id}")
    public Products getOneProduct(@PathVariable int id) {
        if (productService.getOneUser(id).getShowing().equals("NotShow"))
            return productService.getOneUser(id);
        return null;
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.PUT)
    public Products update(@PathVariable int id, @RequestBody Products products) {
            return productService.update(products);
    }

}
