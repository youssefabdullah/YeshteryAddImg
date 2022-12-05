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
public class ProductBeans {
    private int id;
    @Size(min = 2,max = 400,message = "The Description is not valid")
    private String description;
    @Size(min = 2,max = 400,message = "The category is not valid")
    private String category;

    private String img;
}
