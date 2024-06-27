package com.wsd.ecommerce.mapper;


import com.wsd.ecommerce.entity.Customer;
import com.wsd.ecommerce.entity.WishlistItem;
import com.wsd.ecommerce.payload.response.CustomerResponse;
import com.wsd.ecommerce.payload.response.WishListItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListItemMapper {

    private final ItemMapper itemMapper;

    public WishListItemResponse toWishListItemResponse(WishlistItem wishlistItem) {
        return WishListItemResponse.builder()
                .id(wishlistItem.getId())
                .name(itemMapper.toItemResponse(wishlistItem.getItem()).getName())
                .build();
    }
}
