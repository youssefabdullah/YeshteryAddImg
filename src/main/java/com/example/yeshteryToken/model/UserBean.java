package com.example.yeshteryToken.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private int id;
    @Size(min = 2,max = 400,message = "The User Name is not valid")
    private String username;
    @Size(min = 6,max = 4000,message = "The Password is not valid")
    private String password;
}
