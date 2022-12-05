package com.example.yeshteryToken.services;


import com.example.yeshteryToken.entity.Users;
import com.example.yeshteryToken.model.UserBean;

import java.util.List;

public interface UserService {
    public UserBean create(UserBean users);

    public List<Users> getAll();

    public Users getOneUser(int id);

    public Users update(Users users);

    public void delete(int id);
}
