package com.example.yeshteryToken.repository;


import com.example.yeshteryToken.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
