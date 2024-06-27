package com.wsd.ecommerce.controller;


import com.wsd.ecommerce.entity.Item;
import com.wsd.ecommerce.payload.response.ItemResponse;
import com.wsd.ecommerce.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/topSellingItemsAllTime")
    public List<ItemResponse> getTopSellingItemsAllTime() {
        return itemService.getTopSellingItemsAllTime();
    }

    @GetMapping("/topSellingItemsLastMonth")
    public List<ItemResponse> getTopSellingItemsLastMonth() {
        return itemService.getTopSellingItemsLastMonth();
    }
}
