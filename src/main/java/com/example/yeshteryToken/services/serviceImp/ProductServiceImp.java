package com.example.yeshteryToken.services.serviceImp;

import com.example.yeshteryToken.entity.Products;
import com.example.yeshteryToken.model.ProductBeans;
import com.example.yeshteryToken.repository.ProductRepo;
import com.example.yeshteryToken.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    String path = "F:\\Job\\yeshteryToken\\src\\main\\resources\\static\\image";
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Products create(ProductBeans product, MultipartFile file) {
        try {

            Files.copy(file.getInputStream(), Paths.get(path + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            product.setImg(path + "\\" + file.getOriginalFilename());
        } catch (Exception e) {
            System.out.println("error img");
        }
        Products products = productsConvertToProductBeans(product);
        return productRepo.save(products);
    }

    public Products productsConvertToProductBeans(ProductBeans productBeans) {
        Products products = new Products();
        products.setDescription(productBeans.getDescription());
        products.setCategory(productBeans.getCategory());
        products.setImg(productBeans.getImg());
        products.setShowing("NotShow");
        return products;
    }

    @Override
    public List<Products> getAll() {
        return productRepo.findAll()
                .stream()
                .filter(products -> products.getShowing().equals("Accept"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Products> getAllAdmin() {
        return productRepo.findAll()
                .stream()
                .filter(products -> products.getShowing().equals("NotShow"))
                .collect(Collectors.toList());
    }

    @Override
    public Products getOneUser(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Products update(Products product) {
        if (product.getShowing().equals("Reject")) {
            File file = new File(product.getImg());
            if (file.delete()) System.out.println("The file is Delete");
            product.setImg("");
            return productRepo.save(product);
        } else if (product.getShowing().equals("Accept")) {
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
