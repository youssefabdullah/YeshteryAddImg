package com.example.yeshteryToken.services.serviceImp;


import com.example.yeshteryToken.entity.Users;
import com.example.yeshteryToken.model.UserBean;
import com.example.yeshteryToken.repository.UserRepo;
import com.example.yeshteryToken.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    private UserRepo userRepo;

    @Autowired
    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserBean create(UserBean users) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        users.setPassword(encoder.encode(users.getPassword()));
        Users user = UserBeanConvertToUser(users);
        user=userRepo.save(user);
         users.setId(user.getId());
         return users;
    }

    public Users UserBeanConvertToUser(UserBean userBean) {
        Users users = new Users();
        users.setPassword(userBean.getPassword());
        users.setUsername(userBean.getUsername());
        users.setRole("USER");
        return users;
    }

    @Override
    public List<Users> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Users getOneUser(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Users update(Users users) {
        return userRepo.save(users);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
