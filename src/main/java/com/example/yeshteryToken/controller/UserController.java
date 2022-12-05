package com.example.yeshteryToken.controller;


import com.example.yeshteryToken.entity.Users;
import com.example.yeshteryToken.model.UserBean;
import com.example.yeshteryToken.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAll() {
        return userService.getAll();
    }

    @PostMapping
    @RequestMapping("addUser")
    public UserBean addUser(@Valid @RequestBody UserBean users) {
        return userService.create(users);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    public Users update(@PathVariable int id, @RequestBody Users users) {
//        return userService.update(users);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable int id) {
//        userService.delete(id);
    //   }
//@GetMapping
//@RequestMapping("{id}")
//public Users getOne(@PathVariable int id) {
//    return userService.getOneUser(id);
//}
}
