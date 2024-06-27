package com.wsd.ecommerce.controller;


import com.wsd.ecommerce.payload.response.WishListItemResponse;
import com.wsd.ecommerce.service.WishlistItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wishlistItem")
public class WishListItemController {

    private final WishlistItemService wishlistItemService;

    @GetMapping("/wishlist/{customerId}")
    public List<WishListItemResponse> getWishlist(@PathVariable Long customerId) {
        return wishlistItemService.getWishlist(customerId);
    }
}
