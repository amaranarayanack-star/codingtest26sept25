package com.codingtest26sept25.codingtest;

import com.codingtest26sept25.codingtest.dto.ProductSold;
import com.codingtest26sept25.codingtest.dto.TopSeller;
import com.codingtest26sept25.codingtest.service.TopSellerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
@DisplayName("Top Seller Service Unit Tests")
public class TopSellerServiceTest {

    @InjectMocks
    private TopSellerService topSellerService;

    @InjectMocks
    private ProductSold productSold;

    @InjectMocks

    private TopSeller topSeller;


    // Happy path flow
    @Test
    void testGetTopSellersWithNoTies() {
        List<ProductSold> sales = Arrays.asList(
                new ProductSold(1, "Laptop", "Electronics", 100),
                new ProductSold(2, "Mobile", "Electronics", 300),
                new ProductSold(3, "Shirt", "Clothing", 200),
                new ProductSold(4, "Jeans", "Clothing", 250),
                new ProductSold(5, "Apple", "Grocery", 500),
                new ProductSold(6, "Rice Bag", "Grocery", 400)
        );

        List<com.codingtest26sept25.codingtest.dto.TopSeller> result = topSellerService.getCategoryWiseTopSales(sales);
        assertEquals(3, result.size());
        assertEquals("Mobile", result.stream().filter(p -> p.getCategory().equals("Electronics")).findFirst().get().getName());
        assertEquals("Jeans", result.stream().filter(p -> p.getCategory().equals("Clothing")).findFirst().get().getName());
        assertEquals("Apple", result.stream().filter(p -> p.getCategory().equals("Grocery")).findFirst().get().getName());
    }

    // Test In case of same quantity is sold"
    @Test
    void testGetTopSellersWithTie() {
        List<ProductSold> sales = Arrays.asList(
                new ProductSold(7, "Bag", "Accessories", 50),
                new ProductSold(8, "Watch", "Accessories", 150),
                new ProductSold(9, "Earrings", "Accessories", 150)
        );

        List<TopSeller> result = topSellerService.getCategoryWiseTopSales(sales);
        assertEquals(1, result.size());
        assertEquals("Earrings", result.get(0).getName());
    }

    // Test for multiple products with same quantity in a category
    @Test
    void testMultipleTies() {
        List<ProductSold> sales = Arrays.asList(
                new ProductSold(20, "Notebook", "Office", 50),
                new ProductSold(21, "Stapler", "Office", 120),
                new ProductSold(22, "Pen", "Office", 120),
                new ProductSold(23, "Paper", "Office", 120)
        );

        List<TopSeller> result = topSellerService.getCategoryWiseTopSales(sales);
        assertEquals(1, result.size());
        assertEquals("Paper", result.get(0).getName());
    }

    // empty sales list
    @Test
    void testEmptySalesList() {
        List<ProductSold> sales = Collections.emptyList();
        List<TopSeller> result = topSellerService.getCategoryWiseTopSales(sales);
        assertTrue(result.isEmpty());
    }

    // Single product single category
    @Test
    void testSingleProduct() {
        List<ProductSold> sales = Arrays.asList(
                new ProductSold(10, "T-Shirt", "Clothing", 120)
        );

        List<TopSeller> result = topSellerService.getCategoryWiseTopSales(sales);
        assertEquals(1, result.size());
        assertEquals("T-Shirt", result.get(0).getName());
    }
}
