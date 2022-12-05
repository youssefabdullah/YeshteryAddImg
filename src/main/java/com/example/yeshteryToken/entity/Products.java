package com.example.yeshteryToken.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String description;
    private String category;
    private String img;
    private String showing;
    private String mark;
}
