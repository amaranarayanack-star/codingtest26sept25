package com.codingtest26sept25.codingtest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SellerResponse {
    @JsonProperty("topSellers")
    private List<TopSeller> topSellerList;

    public SellerResponse(List<TopSeller> topSellerList) {
    this.topSellerList = topSellerList;
    }

}