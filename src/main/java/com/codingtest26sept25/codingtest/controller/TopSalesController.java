package com.codingtest26sept25.codingtest.controller;

import com.codingtest26sept25.codingtest.dto.ProductSoldRequest;
import com.codingtest26sept25.codingtest.dto.SellerResponse;
import com.codingtest26sept25.codingtest.dto.TopSeller;
import com.codingtest26sept25.codingtest.service.TopSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class TopSalesController {
    @Autowired
    private final TopSellerService topSellerService;

    public TopSalesController(TopSellerService topSellerService) {
        this.topSellerService = topSellerService;
    }

    @PostMapping("/topproducts")
    public ResponseEntity<SellerResponse> getTopSaleProducts(@RequestBody ProductSoldRequest request){
        List<TopSeller> topSellerList = topSellerService.getCategoryWiseTopSales(request.getSales());
        return ResponseEntity.ok(new SellerResponse(topSellerList));
    }
}
