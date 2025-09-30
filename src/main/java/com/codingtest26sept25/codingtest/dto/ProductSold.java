package com.codingtest26sept25.codingtest.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductSold {
    //Getters and setters
    //declaration of attributes
    private int productId;
    private String name;
    private String category;
    private int quantitySold;

    public ProductSold(int productId, String name, String category, int quantitySold) {
        this.productId=productId;
        this.name=name;
        this.category=category;
        this.quantitySold=quantitySold;
    }

    public ProductSold(){

    }

    //Override the toString method to pass the dto
    @Override
    public String toString() {
        return "ProductSold{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", quantitySold=" + quantitySold +
                '}';
    }

}