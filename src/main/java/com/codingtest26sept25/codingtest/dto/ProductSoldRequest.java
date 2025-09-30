package com.codingtest26sept25.codingtest.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductSoldRequest {
    private List<ProductSold> sales;

}