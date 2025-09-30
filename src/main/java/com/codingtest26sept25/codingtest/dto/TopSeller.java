package com.codingtest26sept25.codingtest.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TopSeller{
    private String category;
    private int productId;
    private String name;
    private int quantitySold;

    public TopSeller(String category, int productId, String name, int quantitySold) {
    this.category=category;
    this.quantitySold=quantitySold;
    this.name=name;
    this.productId=productId;
    }

}