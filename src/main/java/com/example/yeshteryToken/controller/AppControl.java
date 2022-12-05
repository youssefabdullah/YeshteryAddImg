package com.example.yeshteryToken.controller;


import com.example.yeshteryToken.entity.Products;
import com.example.yeshteryToken.entity.Users;
import com.example.yeshteryToken.model.AuthanticationRequest;
import com.example.yeshteryToken.model.AuthanticationResponse;
import com.example.yeshteryToken.model.ProductBeans;
import com.example.yeshteryToken.repository.UserRepo;
import com.example.yeshteryToken.security.Jwt.JwtUtil;
import com.example.yeshteryToken.security.MyUserDetailsService;
import com.example.yeshteryToken.services.ProductService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
public class AppControl {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    ProductService productService;

    @PostMapping(value = {"/img"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Products add(@Valid @RequestPart("product") ProductBeans products, @RequestPart("file") MultipartFile file) throws Exception {

        return productService.create(products, file);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthanticationRequest request) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(request.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
//            s = jwt;
            return ResponseEntity.ok(new AuthanticationResponse(jwt));
        } catch (Exception e) {
            System.out.println("The User is Not Found");
        }
        return null;
    }


}
//    String s = "";
//
//    @RequestMapping("/api/user")
//    public String getdat() {
//        return jwtUtil.extractUsername(s);
//    }