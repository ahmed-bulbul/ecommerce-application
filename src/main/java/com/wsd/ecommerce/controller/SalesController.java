package com.wsd.ecommerce.controller;

import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.payload.response.WishListItemResponse;
import com.wsd.ecommerce.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("/wishlist/{customerId}")
    public List<WishListItemResponse> getWishlist(@PathVariable Long customerId) {
        return salesService.getWishlist(customerId);
    }

    @GetMapping("/totalSalesToday")
    public Double getTotalSalesToday() {
        return salesService.getTotalSalesToday();
    }

    @GetMapping("/maxSalesInDateRange")
    public Double getMaxSalesInDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return salesService.getMaxSalesInDateRange(startDate, endDate);
    }

    @GetMapping("/topSellingItemsAllTime")
    public List<Item> getTopSellingItemsAllTime() {
        return salesService.getTopSellingItemsAllTime();
    }

    @GetMapping("/topSellingItemsLastMonth")
    public List<Item> getTopSellingItemsLastMonth() {
        return salesService.getTopSellingItemsLastMonth();
    }
}
