package com.codingtest26sept25.codingtest.service;

import com.codingtest26sept25.codingtest.dto.ProductSold;
import com.codingtest26sept25.codingtest.dto.TopSeller;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TopSellerService {

    public List<TopSeller> getCategoryWiseTopSales(List<ProductSold> sales){
        //Null check
        if(sales==null || sales.isEmpty()){
            //empty list
            return List.of();
        }
        //Comparator creation for quantity and than category name
        Comparator<ProductSold> topSellerComparator = Comparator.comparing(ProductSold::getQuantitySold).reversed()
                .thenComparing(ProductSold::getName);
        // Process the values to get the product with maximum sales
        Map<String, ProductSold> topSellerMap = sales.stream().
                collect(Collectors.toMap(ProductSold::getCategory, sale->sale,
                        (sale1, sale2)->topSellerComparator.compare(sale1, sale2) >= 0 ? sale2 : sale1));

        return topSellerMap.values().stream().map(productSold -> new TopSeller(
                        productSold.getCategory(),
                        productSold.getProductId(),
                        productSold.getName(),
                        productSold.getQuantitySold()
                )
        ).collect(Collectors.toList());
    }
}
