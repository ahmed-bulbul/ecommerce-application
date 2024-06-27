package com.wsd.ecommerce.controller;

import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.payload.response.ItemResponse;
import com.wsd.ecommerce.payload.response.WishListItemResponse;
import com.wsd.ecommerce.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {

    private final SalesService salesService;


    @GetMapping("/totalSalesToday")
    public Double getTotalSalesToday() {
        return salesService.getTotalSalesToday();
    }

    @GetMapping("/maxSalesInDateRange")
    public Double getMaxSalesInDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return salesService.getMaxSalesInDateRange(startDate, endDate);
    }


}
